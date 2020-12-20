package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.ActivityMapper;
import quick.pager.shop.mapper.AssembleActivityRuleMapper;
import quick.pager.shop.model.Activity;
import quick.pager.shop.model.AssembleActivityRule;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityRuleResponse;

import quick.pager.shop.service.AssembleRuleService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 拼团规则
 *
 * @author siguiyang
 */
@Service
public class AssembleServiceRuleImpl extends ServiceImpl<AssembleActivityRuleMapper, AssembleActivityRule> implements AssembleRuleService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Response<AssembleActivityRuleResponse> info(Long activityId) {

        Activity activity = this.activityMapper.selectById(activityId);

        Assert.isTrue(Objects.nonNull(activity), () -> "活动不存在");

        LambdaQueryWrapper<AssembleActivityRule> wrapper = new LambdaQueryWrapper<AssembleActivityRule>()
                .eq(AssembleActivityRule::getActivityId, activityId);
        AssembleActivityRule updateRule = this.baseMapper.selectOne(wrapper);

        AssembleActivityRuleResponse response = new AssembleActivityRuleResponse();
        LocalDateTime time = DateUtils.dateTime();
        if (Objects.nonNull(updateRule)) {
            response.setId(updateRule.getId());
            response.setActivityId(activityId);
            response.setPurchaseLimit(updateRule.getPurchaseLimit());
            response.setAssembleCount(updateRule.getAssembleCount());
            response.setDescription(updateRule.getDescription());
            response.setCreateTime(time);
        }
        response.setUpdateTime(time);

        response.setActivityId(activityId);
        response.setActivityName(activity.getActivityName());
        return Response.toResponse(response);
    }

    @Override
    public Response<Long> rule(AssembleRuleSaveRequest request) {
        Activity activity = this.activityMapper.selectById(request.getActivityId());

        Assert.isTrue(Objects.nonNull(activity), () -> "活动不存在");

        LambdaQueryWrapper<AssembleActivityRule> wrapper = new LambdaQueryWrapper<AssembleActivityRule>()
                .eq(AssembleActivityRule::getActivityId, request.getActivityId());
        AssembleActivityRule rule = this.baseMapper.selectOne(wrapper);

        AssembleActivityRule activityRule = new AssembleActivityRule();
        BeanCopier.copy(request, activityRule);
        // 不存在则新增
        if (Objects.isNull(rule)) {
            activityRule.setServerStatus(Boolean.FALSE);
            activityRule.setDeleteStatus(Boolean.FALSE);
            activityRule.setCreateTime(DateUtils.dateTime());
            this.baseMapper.insert(activityRule);
        } else {
            this.baseMapper.updateById(activityRule);
        }

        return Response.toResponse(activityRule.getId());
    }
}
