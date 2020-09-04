package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.ExchangeActivityMapper;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.model.ExchangeActivity;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.ExchangeActivityRuleService;
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
    private ExchangeActivityMapper exchangeActivityMapper;

    @Override
    public Response<List<ExchangeActivityRuleResponse>> queryList(Long activityId) {

        ExchangeActivity exchangeActivity = exchangeActivityMapper.selectById(activityId);

        if (Objects.isNull(exchangeActivity) || exchangeActivity.getServerStatus() || exchangeActivity.getDeleteStatus()) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "不存在此活动");
        }

        LambdaQueryWrapper<ExchangeActivityRule> wrapper = new LambdaQueryWrapper<ExchangeActivityRule>()
                .eq(ExchangeActivityRule::getDeleteStatus, Boolean.FALSE)
                .eq(ExchangeActivityRule::getActivityId, activityId);
        List<ExchangeActivityRule> rules = this.baseMapper.selectList(wrapper);

        return new Response<>(rules.stream()
                .map(item -> {
                    ExchangeActivityRuleResponse response = new ExchangeActivityRuleResponse();
                    response.setId(item.getId());
                    response.setActivityId(activityId);
                    response.setActivityName(exchangeActivity.getActivityName());
                    response.setOrderAmount(item.getOrderAmount());
                    response.setRuleName(item.getRuleName());
                    response.setServerStatus(item.getServerStatus());
                    response.setCreateTime(item.getCreateTime());
                    response.setUpdateTime(item.getUpdateTime());
                    response.setCreateUser(item.getCreateUser());
                    response.setUpdateUser(item.getUpdateUser());
                    return response;
                }).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(ExchangeActivityRuleSaveRequest request) {
        ExchangeActivityRule rule = this.convert(request);
        rule.setDeleteStatus(Boolean.FALSE);
        rule.setCreateTime(DateUtils.dateTime());
        rule.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.insert(rule);

        return new Response<>(rule.getId());
    }

    @Override
    public Response<Long> modify(ExchangeActivityRuleSaveRequest request) {

        ExchangeActivityRule rule = this.convert(request);
        rule.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(rule);

        return new Response<>(rule.getId());
    }

    private ExchangeActivityRule convert(ExchangeActivityRuleSaveRequest request) {

        return BeanCopier.create(request, new ExchangeActivityRule()).copy();


    }
}
