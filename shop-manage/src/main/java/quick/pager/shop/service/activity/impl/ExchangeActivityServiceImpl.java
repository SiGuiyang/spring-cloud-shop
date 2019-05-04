package quick.pager.shop.service.activity.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.response.ExchangeMemberResponse;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.ExchangeActivityService;

@Service
public class ExchangeActivityServiceImpl implements ExchangeActivityService {

    @Autowired
    private ActivityClient activityClient;
    @Autowired
    private GoodsClient goodsClient;

    @Override
    public Response getExchangeActivity(Long activityId) {
        return activityClient.getExchangeActivity(activityId);
    }

    @Override
    public Response getExchangeActivitys(ExchangeActivityDTO dto) {
        return activityClient.getExchangeActivitys(dto);
    }

    @Override
    public Response addExchangeActivitys(ExchangeActivityDTO dto) {
        return activityClient.addExchangeActivitys(dto);
    }

    @Override
    public Response modifyExchangeActivitys(ExchangeActivityDTO dto) {
        return activityClient.modifyExchangeActivitys(dto);
    }

    @Override
    public Response getExchangeActivityRules(ExchangeActivityDTO dto) {
        return activityClient.getExchangeActivityRules(dto);
    }

    @Override
    public Response addExchangeActivityRules(ExchangeActivityDTO dto) {
        return activityClient.addExchangeActivityRules(dto);
    }

    @Override
    public Response modifyExchangeActivityRules(ExchangeActivityDTO dto) {
        return activityClient.modifyExchangeActivityRules(dto);
    }

    @Override
    public Response goodsRule(ExchangeActivityDTO dto) {
        return activityClient.exchangeGoodsRule(dto.getActivityId(), dto.getRuleId(), dto.getGoodsId());
    }

    @Override
    public Response goodsRuleInfo(Long activityId, Long goodsId) {
        return activityClient.goodsRuleInfo(activityId, goodsId);
    }

    @Override
    public Response purchaseHistory(ExchangeActivityDTO dto) {
        Response<List<ExchangeMemberResponse>> listResponse = activityClient.purchaseHistory(dto);

        if (ResponseStatus.Code.SUCCESS == listResponse.getCode()) {
            List<ExchangeMemberResponse> data = listResponse.getData();
            // 迭代遍历
            Optional.ofNullable(data).orElse(Collections.emptyList()).forEach(d -> {
                Long goodsId = d.getGoodsId();

                Response<GoodsResponse> goodsResponseResponse = goodsClient.goodsInfo(goodsId);

                // 设置商品信息
                if (ResponseStatus.Code.SUCCESS == goodsResponseResponse.getCode()) {
                    GoodsResponse goodsResponse = goodsResponseResponse.getData();
                    d.setGoodsName(goodsResponse.getGoods().getGoodsName());
                    d.setGoodsAmount(goodsResponse.getGoods().getGoodsAmount());
                }

            });
        }

        return listResponse;
    }
}
