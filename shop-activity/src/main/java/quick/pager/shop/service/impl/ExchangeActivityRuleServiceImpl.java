package quick.pager.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.model.activity.ExchangeActivityRule;
import quick.pager.shop.response.ExchangeActivityRuleResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.ExchangeActivityRuleService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

@Service
public class ExchangeActivityRuleServiceImpl implements ExchangeActivityRuleService {

    @Autowired
    private ExchangeActivityRuleMapper exchangeActivityRuleMapper;

    @Override
    public Response<List<ExchangeActivityRuleResponse>> rules(Long activityId) {

        return new Response<>(exchangeActivityRuleMapper.selectByActivityId(activityId));
    }

    @Override
    public Response createOrModifyRule(ExchangeActivityDTO dto) {

        ExchangeActivityRule rule = BeanCopier.create(dto, new ExchangeActivityRule(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();

        if (null == dto.getId()) {
            rule.setDeleteStatus(Boolean.FALSE);
            rule.setCreateTime(DateUtils.now());
            exchangeActivityRuleMapper.insert(rule);
        } else {
            exchangeActivityRuleMapper.updateById(rule);
        }
        return new Response();
    }
}
