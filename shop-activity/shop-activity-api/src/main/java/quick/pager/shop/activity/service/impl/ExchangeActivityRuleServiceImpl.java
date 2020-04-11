package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.mapper.ExchangeActivityMapper;
import quick.pager.shop.activity.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.activity.model.ExchangeActivity;
import quick.pager.shop.activity.model.ExchangeActivityRule;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.ExchangeActivityRuleService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * 满赠换购活动规则
 *
 * @author siguiyang
 */
@Service
public class ExchangeActivityRuleServiceImpl implements ExchangeActivityRuleService {

    @Autowired
    private ExchangeActivityRuleMapper exchangeActivityRuleMapper;
    @Autowired
    private ExchangeActivityMapper exchangeActivityMapper;

    @Override
    public Response<List<ExchangeActivityRuleResponse>> queryList(Long activityId) {

        ExchangeActivity exchangeActivity = exchangeActivityMapper.selectById(activityId);

        if (Objects.isNull(exchangeActivity) || exchangeActivity.getServerStatus() || exchangeActivity.getDeleteStatus()) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "不存在此活动");
        }

        ExchangeActivityRule exchangeActivityRule = new ExchangeActivityRule();
        exchangeActivityRule.setActivityId(activityId);
        List<ExchangeActivityRule> rules = exchangeActivityRuleMapper.selectList(new QueryWrapper<>(exchangeActivityRule));


        return new Response<>(Optional.ofNullable(rules).orElse(Collections.emptyList()).stream()
                .map(item -> {
                    ExchangeActivityRuleResponse response = new ExchangeActivityRuleResponse();
                    response.setId(item.getId());
                    response.setActivityId(activityId);
                    response.setActivityName(exchangeActivity.getActivityName());
                    response.setOrderAmount(item.getOrderAmount());
                    response.setRuleName(item.getRuleName());
                    response.setServerStatus(item.getServerStatus());
                    response.setCreateTime(item.getCreateTime());
                    return response;
                }).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(ExchangeActivityRuleSaveRequest request) {
        ExchangeActivityRule rule = this.convert(request);
        rule.setDeleteStatus(Boolean.FALSE);
        rule.setCreateTime(DateUtils.dateTime());
        exchangeActivityRuleMapper.insert(rule);

        return new Response<>(rule.getId());
    }

    @Override
    public Response<Long> modify(ExchangeActivityRuleSaveRequest request) {

        ExchangeActivityRule rule = this.convert(request);
        exchangeActivityRuleMapper.updateById(rule);

        return new Response<>(rule.getId());
    }

    private ExchangeActivityRule convert(ExchangeActivityRuleSaveRequest request) {

        return BeanCopier.create(request, new ExchangeActivityRule()).copy();


    }
}
