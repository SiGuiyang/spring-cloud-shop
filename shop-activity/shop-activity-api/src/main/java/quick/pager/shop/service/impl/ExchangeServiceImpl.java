package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.ActivityMapper;
import quick.pager.shop.mapper.ExchangeActivityMembersMapper;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.model.Activity;
import quick.pager.shop.model.ExchangeActivityMember;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRecordPageRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRecordResponse;
import quick.pager.shop.service.ActivityService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.ExchangeService;

/**
 * 满赠换购
 *
 * @author siguiyang
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ExchangeActivityMembersMapper exchangeActivityMembersMapper;
    @Autowired
    private ExchangeActivityRuleMapper exchangeActivityRuleMapper;
    @Autowired
    private ActivityService activityService;
    @Override
    public Response<List<ExchangeActivityRecordResponse>> record(final ExchangeActivityRecordPageRequest request) {

        if (activityService.nonExists(request.getActivityId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "活动不存在");
        }

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

    private ExchangeActivityRecordResponse convert(final ExchangeActivityMember member) {
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
            Activity activity = this.activityMapper.selectById(member.getActivityId());
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
