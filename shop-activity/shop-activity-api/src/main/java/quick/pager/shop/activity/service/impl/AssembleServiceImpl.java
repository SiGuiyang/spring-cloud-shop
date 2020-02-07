package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.activity.model.AssembleActivity;
import quick.pager.shop.activity.model.AssembleActivityMember;
import quick.pager.shop.activity.model.AssembleActivityRule;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.activity.mapper.AssembleActivityGoodsMapper;
import quick.pager.shop.activity.mapper.AssembleActivityMemberMapper;
import quick.pager.shop.activity.mapper.AssembleActivityRuleMapper;
import quick.pager.shop.activity.mapper.AssembleMapper;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.AssembleService;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class AssembleServiceImpl extends ServiceImpl<AssembleMapper, AssembleActivity> implements AssembleService {

    @Autowired
    private AssembleActivityRuleMapper assembleActivityRuleMapper;
    @Autowired
    private AssembleActivityGoodsMapper assembleActivityGoodsMapper;
    @Autowired
    private AssembleActivityMemberMapper assembleActivityMemberMapper;

    @Override
    public Response<List<AssembleActivityResponse>> list(AssemblePageRequest request) {

        QueryWrapper<AssembleActivity> qw = new QueryWrapper<>();

        if (!StringUtils.isEmpty(request.getActivityName())) {
            qw.likeRight("activity_name", request.getActivityName());
        }

        if (!CollectionUtils.isEmpty(request.getTimeRange())) {
            qw.le("begin_time", request.getTimeRange().get(0));
            qw.ge("end_time", request.getTimeRange().get(1));
        }

        qw.orderByDesc("id");

        Response<List<AssembleActivity>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<Long> modify(AssembleSaveRequest request) {
        AssembleActivity assembleActivity = this.conv(request);
        this.baseMapper.updateById(assembleActivity);
        return new Response<>(request.getId());
    }

    @Override
    public Response<Long> create(AssembleSaveRequest request) {

        AssembleActivity assembleActivity = this.conv(request);
        assembleActivity.setServerStatus(Boolean.FALSE);
        assembleActivity.setCreateTime(DateUtils.dateTime());
        assembleActivity.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(assembleActivity);
        return new Response<>(assembleActivity.getId());
    }

    @Override
    public Response<AssembleResponse> ruleInfo(Long activityId) {

        AssembleActivity assembleActivity = this.baseMapper.selectById(activityId);

        if (Objects.isNull(assembleActivity)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "活动已过期");
        }

        AssembleActivityRule rule = new AssembleActivityRule();
        rule.setActivityId(activityId);
        rule.setDeleteStatus(Boolean.FALSE);
        AssembleActivityRule updateRule = assembleActivityRuleMapper.selectOne(new QueryWrapper<>(rule));

        AssembleResponse response = new AssembleResponse();
        if (Objects.nonNull(updateRule)) {
            response.setId(updateRule.getId());
            response.setRuleId(updateRule.getId());
            response.setPurchaseLimit(updateRule.getPurchaseLimit());
            response.setAssembleCount(updateRule.getAssembleCount());
            response.setDescription(updateRule.getDescription());
        }
        response.setActivityId(activityId);
        response.setActivityName(assembleActivity.getActivityName());
        return new Response<>(response);
    }

    @Override
    public Response<Long> modifyRule(AssembleRuleSaveRequest request) {
        AssembleActivityRule queryRule = new AssembleActivityRule();
        queryRule.setActivityId(request.getActivityId());
        queryRule.setDeleteStatus(request.getDeleteStatus());

        AssembleActivityRule rule = assembleActivityRuleMapper.selectOne(new QueryWrapper<>(queryRule));

        AssembleActivityRule activityRule = new AssembleActivityRule();
        BeanCopier.create(request, activityRule).copy();
        // 不存在则新增
        if (Objects.isNull(rule)) {
            activityRule.setDeleteStatus(Boolean.FALSE);
            activityRule.setCreateTime(DateUtils.dateTime());
            assembleActivityRuleMapper.insert(activityRule);
        } else {
            assembleActivityRuleMapper.updateById(activityRule);
        }

        return new Response<>(activityRule.getId());
    }

//    @Override
//    public Response assembleGoods(AssembleDTO request) {
//
//        AssembleActivityGoods activityGoods = BeanCopier.create(request, new AssembleActivityGoods(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
//                .copy();
//        QueryWrapper<AssembleActivityGoods> qw = new QueryWrapper<>();
//        qw.eq("activity_id", request.getActivityId());
//        qw.eq("delete_status", Boolean.FALSE);
//        AssembleActivityGoods goods = assembleActivityGoodsMapper.selectOne(qw);
//
//        if (null == goods) {
//            activityGoods.setCreateTime(DateUtils.dateTime());
//            assembleActivityGoodsMapper.insert(activityGoods);
//
//        } else {
//            assembleActivityGoodsMapper.updateById(goods);
//        }
//
//        return new Response();
//    }

    @Override
    public Response<List<AssembleMemberResponse>> members(AssembleMemberPageRequest request) {

        QueryWrapper<AssembleActivityMember> qw = new QueryWrapper<>();

        qw.eq("t.activity_id", request.getActivityId());
        if (!StringUtils.isEmpty(request.getPhone())) {
            qw.eq("t.phone", request.getPhone());
        }

        qw.orderByDesc("t.record_id");

        int total = assembleActivityMemberMapper.selectCounts(qw);
        List<AssembleMemberResponse> result = Collections.emptyList();
        if (0 < total) {

            result = assembleActivityMemberMapper.selectPages(new Page<>(request.getPage(), request.getPageSize(), false), qw)
                    .getRecords();
        }
        return Response.toResponse(result, total);
    }

    /**
     * AssembleSaveRequest -> AssembleActivity
     */
    public AssembleActivity conv(AssembleSaveRequest request) {

        AssembleActivity assembleActivity = new AssembleActivity();
        BeanCopier.create(request, assembleActivity).copy();
        if (!CollectionUtils.isEmpty(request.getTimeRange())) {
            assembleActivity.setBeginTime(request.getTimeRange().get(0));
            assembleActivity.setEndTime(request.getTimeRange().get(1));
        }
        return assembleActivity;
    }

    /**
     * activity -> AssembleActivityResponse
     */
    private AssembleActivityResponse convert(AssembleActivity activity) {
        AssembleActivityResponse response = new AssembleActivityResponse();
        BeanCopier.create(activity, response).copy();
        return response;
    }
}
