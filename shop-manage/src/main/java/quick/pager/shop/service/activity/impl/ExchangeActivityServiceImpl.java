package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.ExchangeActivityService;

@Service
public class ExchangeActivityServiceImpl implements ExchangeActivityService {

    @Autowired
    private ActivityClient activityClient;

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
    public Response purchaseHistory(ExchangeActivityDTO dto) {
        return activityClient.purchaseHistory(dto);
    }
}
