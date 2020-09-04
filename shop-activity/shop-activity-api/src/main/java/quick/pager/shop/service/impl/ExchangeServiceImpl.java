package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.ExchangeActivityMapper;
import quick.pager.shop.mapper.ExchangeActivityMembersMapper;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.model.ExchangeActivity;
import quick.pager.shop.model.ExchangeActivityMember;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRecordPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRecordResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.ExchangeService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 满赠换购
 *
 * @author siguiyang
 */
@Service
public class ExchangeServiceImpl extends ServiceImpl<ExchangeActivityMapper, ExchangeActivity> implements ExchangeService {

    @Autowired
    private ExchangeActivityMembersMapper exchangeActivityMembersMapper;
    @Autowired
    private ExchangeActivityRuleMapper exchangeActivityRuleMapper;


    @Override
    public Response<ExchangeActivityResponse> queryInfo(Long activityId) {
        ExchangeActivity activity = this.baseMapper.selectById(activityId);
        return new Response<>(this.convert(activity));
    }

    @Override
    public Response<List<ExchangeActivityResponse>> queryPage(ExchangeActivityPageRequest request) {

        LambdaQueryWrapper<ExchangeActivity> qw = new LambdaQueryWrapper<ExchangeActivity>()
                .likeRight(StringUtils.isNotEmpty(request.getActivityName()), ExchangeActivity::getActivityName, request.getActivityName())
                .between(CollectionUtils.isNotEmpty(request.getTimeRange()), ExchangeActivity::getBeginTime, request.getTimeRange().get(0), request.getTimeRange().get(1));

        Response<List<ExchangeActivity>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<Long> create(ExchangeActivitySaveRequest request) {

        ExchangeActivity exchangeActivity = this.convert(request);

        exchangeActivity.setDeleteStatus(Boolean.FALSE);
        exchangeActivity.setServerStatus(Boolean.FALSE);
        exchangeActivity.setCreateTime(DateUtils.dateTime());
        exchangeActivity.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.insert(exchangeActivity);

        return new Response<>(exchangeActivity.getId());
    }

    @Override
    public Response<Long> modify(ExchangeActivitySaveRequest request) {
        ExchangeActivity exchangeActivity = this.convert(request);
        exchangeActivity.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(exchangeActivity);

        return new Response<>(exchangeActivity.getId());
    }

    @Override
    public Response<List<ExchangeActivityRecordResponse>> record(ExchangeActivityRecordPageRequest request) {
        LambdaQueryWrapper<ExchangeActivityMember> wrapper = new LambdaQueryWrapper<ExchangeActivityMember>()
                .eq(ExchangeActivityMember::getDeleteStatus, Boolean.FALSE)
                .eq(ExchangeActivityMember::getActivityId, request.getActivityId())
                .likeRight(StringUtils.isNotBlank(request.getPhone()), ExchangeActivityMember::getPhone, request.getPhone())
                .eq(Objects.isNull(request.getRuleId()), ExchangeActivityMember::getRuleId, request.getRuleId());

        List<ExchangeActivityRecordResponse> responseList = Collections.emptyList();
        int count = exchangeActivityMembersMapper.selectCount(wrapper);
        if (0 < count) {
            Page<ExchangeActivityMember> page = new Page<>(request.getPage(), request.getPageSize());
            List<ExchangeActivityMember> records = exchangeActivityMembersMapper.selectPage(page, wrapper).getRecords();
            responseList = records.stream().map(this::convert).collect(Collectors.toList());
        }
        return Response.toResponse(responseList, count);
    }

    private ExchangeActivity convert(ExchangeActivitySaveRequest request) {
        return BeanCopier.create(request, new ExchangeActivity()).copy();
    }

    private ExchangeActivityResponse convert(ExchangeActivity activity) {
        return BeanCopier.create(activity, new ExchangeActivityResponse()).copy();
    }

    private ExchangeActivityRecordResponse convert(ExchangeActivityMember member) {
        ExchangeActivityRecordResponse response = new ExchangeActivityRecordResponse();

        response.setId(member.getId());
        response.setPhone(member.getPhone());
        response.setCreateTime(member.getCreateTime());
        response.setUpdateTime(member.getUpdateTime());
        response.setCreateUser(member.getCreateUser());
        response.setUpdateUser(member.getUpdateUser());
        response.setDeleteStatus(member.getDeleteStatus());
        // 活动名称
        if (Objects.nonNull(member.getActivityId())) {
            ExchangeActivity activity = this.baseMapper.selectById(member.getActivityId());
            response.setActivityId(member.getActivityId());
            response.setActivityName(Objects.nonNull(activity) ? activity.getActivityName() : null);
        }
        // 活动规则
        if (Objects.nonNull(member.getRuleId())) {
            ExchangeActivityRule rule = exchangeActivityRuleMapper.selectById(member.getRuleId());
            response.setRuleId(member.getRuleId());
            response.setRuleName(Objects.nonNull(rule) ? rule.getRuleName() : null);
        }
        return response;
    }
}
