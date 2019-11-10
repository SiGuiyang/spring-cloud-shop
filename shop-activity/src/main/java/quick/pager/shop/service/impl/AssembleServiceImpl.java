package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.activity.AssembleDTO;
import quick.pager.shop.mapper.AssembleActivityGoodsMapper;
import quick.pager.shop.mapper.AssembleActivityMemberMapper;
import quick.pager.shop.mapper.AssembleActivityRuleMapper;
import quick.pager.shop.mapper.AssembleMapper;
import quick.pager.shop.model.activity.AssembleActivity;
import quick.pager.shop.model.activity.AssembleActivityGoods;
import quick.pager.shop.model.activity.AssembleActivityMember;
import quick.pager.shop.model.activity.AssembleActivityRule;
import quick.pager.shop.response.AssembleMemberResponse;
import quick.pager.shop.response.AssembleResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.AssembleService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

@Service
public class AssembleServiceImpl implements AssembleService {

    @Autowired
    private AssembleMapper assembleMapper;
    @Autowired
    private AssembleActivityRuleMapper assembleActivityRuleMapper;
    @Autowired
    private AssembleActivityGoodsMapper assembleActivityGoodsMapper;
    @Autowired
    private AssembleActivityMemberMapper assembleActivityMemberMapper;

    @Override
    public Response list(AssembleDTO dto) {
        QueryWrapper<AssembleActivity> qw = new QueryWrapper<>();

        if (StringUtils.isEmpty(dto.getActivityName())) {
            qw.likeRight("activity_name", dto.getActivityName());
        }

        if (null != dto.getBeginTime()) {
            qw.le("begin_time", dto.getBeginTime());
        }
        if (null != dto.getEndTime()) {
            qw.ge("end_time", dto.getEndTime());
        }

        qw.orderByDesc("id");

        Integer count = assembleMapper.selectCount(qw);
        List<AssembleActivity> result = Collections.emptyList();
        if (0 < count) {
            result = assembleMapper.selectPage(new Page<>(dto.getPage(), dto.getPageSize(), false), qw)
                    .getRecords();

        }

        return Response.toResponse(result, 0);
    }

    @Override
    public Response modify(AssembleDTO dto) {

        if (null == dto.getId()) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        AssembleActivity assembleActivity = BeanCopier.create(dto, new AssembleActivity(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
        assembleMapper.updateById(assembleActivity);
        return new Response();
    }

    @Override
    public Response create(AssembleDTO dto) {

        AssembleActivity assembleActivity = BeanCopier.create(dto, new AssembleActivity(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
        assembleActivity.setCreateTime(DateUtils.dateTime());
        assembleActivity.setDeleteStatus(Boolean.FALSE);
        assembleMapper.insert(assembleActivity);
        return new Response();
    }

    @Override
    public Response<AssembleResponse> ruleInfo(Long activityId) {

        AssembleActivity assembleActivity = assembleMapper.selectById(activityId);

        if (null == assembleActivity) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "活动已过期");
        }

        QueryWrapper<AssembleActivityRule> qw = new QueryWrapper<>();
        qw.eq("activity_id", activityId);
        qw.eq("delete_status", Boolean.FALSE);
        AssembleActivityRule rule = assembleActivityRuleMapper.selectOne(qw);

        AssembleResponse response = new AssembleResponse();
        if (null != rule) {
            response.setId(rule.getId());
            response.setRuleId(rule.getId());
            response.setPurchaseLimit(rule.getPurchaseLimit());
            response.setAssembleCount(rule.getAssembleCount());
            response.setDescription(rule.getDescription());
        }
        response.setActivityId(activityId);
        response.setActivityName(assembleActivity.getActivityName());
        return new Response<>(response);
    }

    @Override
    public Response modifyRule(AssembleDTO dto) {
        QueryWrapper<AssembleActivityRule> qw = new QueryWrapper<>();
        qw.eq("activity_id", dto.getActivityId());
        qw.eq("delete_status", Boolean.FALSE);
        AssembleActivityRule rule = assembleActivityRuleMapper.selectOne(qw);

        AssembleActivityRule activityRule = BeanCopier.create(dto, new AssembleActivityRule(), CopyOptions.create().setIgnoreError(true).setIgnoreNullValue(true))
                .copy();
        // 不存在则新增
        if (null == rule) {
            activityRule.setDeleteStatus(Boolean.FALSE);
            activityRule.setCreateTime(DateUtils.dateTime());
            assembleActivityRuleMapper.insert(activityRule);
        } else {
            assembleActivityRuleMapper.updateById(activityRule);
        }

        return new Response();
    }

    @Override
    public Response assembleGoods(AssembleDTO dto) {

        AssembleActivityGoods activityGoods = BeanCopier.create(dto, new AssembleActivityGoods(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
        QueryWrapper<AssembleActivityGoods> qw = new QueryWrapper<>();
        qw.eq("activity_id", dto.getActivityId());
        qw.eq("delete_status", Boolean.FALSE);
        AssembleActivityGoods goods = assembleActivityGoodsMapper.selectOne(qw);

        if (null == goods) {
            activityGoods.setCreateTime(DateUtils.dateTime());
            assembleActivityGoodsMapper.insert(activityGoods);

        } else {
            assembleActivityGoodsMapper.updateById(goods);
        }

        return new Response();
    }

    @Override
    public Response members(AssembleDTO dto) {

        QueryWrapper<AssembleActivityMember> qw = new QueryWrapper<>();

        qw.eq("t.activity_id", dto.getActivityId());
        if (!StringUtils.isEmpty(dto.getPhone())) {
            qw.eq("t.phone", dto.getPhone());
        }

        qw.orderByDesc("t.record_id");

        int total = assembleActivityMemberMapper.selectCounts(qw);
        List<AssembleMemberResponse> result = Collections.emptyList();
        if (0 < total) {

            result = assembleActivityMemberMapper.selectPages(new Page<>(dto.getPage(), dto.getPageSize(), false), qw)
                    .getRecords();
        }
        return Response.toResponse(result, total);
    }
}
