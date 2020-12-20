package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.ActivityMapper;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.model.Activity;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.ExchangeActivityRuleService;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 满赠换购活动规则
 *
 * @author siguiyang
 */
@Service
public class ExchangeActivityRuleServiceImpl extends ServiceImpl<ExchangeActivityRuleMapper, ExchangeActivityRule> implements ExchangeActivityRuleService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Response<List<ExchangeActivityRuleResponse>> queryList(final Long activityId) {

        Activity activity = activityMapper.selectById(activityId);
        Assert.isTrue(Objects.nonNull(activity), () -> "不存在此活动");

        List<ExchangeActivityRule> rules = this.baseMapper.selectList(new LambdaQueryWrapper<ExchangeActivityRule>()
                .eq(ExchangeActivityRule::getActivityId, activityId));

        return Response.toResponse(rules.stream()
                .map(item -> {
                    ExchangeActivityRuleResponse response = new ExchangeActivityRuleResponse();
                    response.setId(item.getId());
                    response.setActivityId(activityId);
                    response.setActivityName(activity.getActivityName());
                    response.setOrderAmount(item.getOrderAmount());
                    response.setRuleName(item.getRuleName());
                    response.setState(item.getState());
                    response.setCreateTime(item.getCreateTime());
                    response.setUpdateTime(item.getUpdateTime());
                    response.setCreateUser(item.getCreateUser());
                    response.setUpdateUser(item.getUpdateUser());
                    response.setDeleteStatus(item.getDeleteStatus());
                    return response;
                }).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(final ExchangeActivityRuleSaveRequest request) {

        Activity activity = activityMapper.selectById(request.getActivityId());
        Assert.isTrue(Objects.nonNull(activity), () -> "不存在此活动");

        ExchangeActivityRule rule = this.convert(request);
        rule.setState(Boolean.FALSE);
        rule.setDeleteStatus(Boolean.FALSE);
        rule.setCreateTime(DateUtils.dateTime());
        rule.setUpdateTime(DateUtils.dateTime());
        Assert.isTrue(this.baseMapper.insert(rule) > 0, () -> "创建满赠规则失败");

        return Response.toResponse(rule.getId());
    }

    @Override
    public Response<Long> modify(final ExchangeActivityRuleSaveRequest request) {

        Activity activity = activityMapper.selectById(request.getActivityId());
        Assert.isTrue(Objects.nonNull(activity), () -> "不存在此活动");

        ExchangeActivityRule activityRule = this.baseMapper.selectById(request.getId());
        Assert.isTrue(Objects.nonNull(activityRule), () -> "不存在此活动规则");


        ExchangeActivityRule rule = this.convert(request);
        rule.setUpdateTime(DateUtils.dateTime());
        Assert.isTrue(this.baseMapper.updateById(rule) > 0, () -> "活动规则更新失败");

        return Response.toResponse(rule.getId());
    }

    @Override
    public Response<Long> delete(final Long id, final Long activityId) {

        Activity activity = activityMapper.selectById(activityId);
        Assert.isTrue(Objects.nonNull(activity), () -> "不存在此活动");

        ExchangeActivityRule activityRule = this.baseMapper.selectById(id);
        Assert.isTrue(Objects.nonNull(activityRule), () -> "不存在此活动规则");

        Assert.isTrue(this.baseMapper.deleteById(id) > 0, () -> "删除规则失败");
        return Response.toResponse(id);
    }

    /**
     * request -> DO
     *
     * @param request 请求参数
     * @return DO
     */
    private ExchangeActivityRule convert(final ExchangeActivityRuleSaveRequest request) {

        return BeanCopier.copy(request, new ExchangeActivityRule());


    }
}
