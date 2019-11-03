package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.activity.ExchangeClient;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.ExchangeActivityService;

@Service
public class ExchangeActivityServiceImpl implements ExchangeActivityService {

    @Autowired
    private ExchangeClient exchangeClient;
//    @Autowired
//    private GoodsClient goodsClient;

    @Override
    public Response info(Long activityId) {
        return exchangeClient.getExchangeActivity(activityId);
    }

    @Override
    public Response list(ExchangeActivityDTO dto) {
        return exchangeClient.list(dto);
    }

    @Override
    public Response create(ExchangeActivityDTO dto) {
        return exchangeClient.create(dto);
    }

    @Override
    public Response modify(ExchangeActivityDTO dto) {
        return exchangeClient.modify(dto);
    }

    @Override
    public Response rules(ExchangeActivityDTO dto) {
        return exchangeClient.ruleList(dto);
    }

    @Override
    public Response createRule(ExchangeActivityDTO dto) {
        return exchangeClient.createRule(dto);
    }

    @Override
    public Response modifyRule(ExchangeActivityDTO dto) {
        return exchangeClient.modifyRule(dto);
    }

    @Override
    public Response goodsRule(ExchangeActivityDTO dto) {
        return exchangeClient.exchangeGoodsRule(dto.getActivityId(), dto.getRuleId(), dto.getGoodsId());
    }

    @Override
    public Response goodsRuleInfo(Long activityId, Long goodsId) {
        return exchangeClient.goodsRuleInfo(activityId, goodsId);
    }

    @Override
    public Response purchaseHistory(ExchangeActivityDTO dto) {

        return null;
    }
}
