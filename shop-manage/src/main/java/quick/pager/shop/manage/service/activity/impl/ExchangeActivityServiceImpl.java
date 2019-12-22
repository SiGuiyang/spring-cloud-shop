package quick.pager.shop.manage.service.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.ExchangeClient;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.manage.param.exchange.ExchangeActivityPageParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityRuleSaveParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivitySaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.ExchangeActivityService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class ExchangeActivityServiceImpl implements ExchangeActivityService {

    @Autowired
    private ExchangeClient exchangeClient;
//    @Autowired
//    private GoodsClient goodsClient;


    @Override
    public Response<List<ExchangeActivityResponse>> list(ExchangeActivityPageParam param) {

        ExchangeActivityPageRequest request = new ExchangeActivityPageRequest();
        request.setActivityName(param.getActivityName());
        request.setPage(param.getPage());
        request.setPageSize(param.getPageSize());
        request.setTimeRange(param.getTimeRange());

        return exchangeClient.queryPage(request);
    }

    @Override
    public Response<Long> create(ExchangeActivitySaveParam param) {
        ExchangeActivitySaveRequest request = new ExchangeActivitySaveRequest();
        BeanCopier.create(param, request).copy();

        return exchangeClient.create(request);
    }

    @Override
    public Response<Long> modify(ExchangeActivitySaveParam param) {
        ExchangeActivitySaveRequest request = new ExchangeActivitySaveRequest();
        BeanCopier.create(param, request).copy();

        return exchangeClient.modify(request);
    }

    @Override
    public Response<List<ExchangeActivityRuleResponse>> rules(Long activityId) {

        return exchangeClient.ruleList(activityId);
    }

    @Override
    public Response<Long> createRule(ExchangeActivityRuleSaveParam param) {

        ExchangeActivityRuleSaveRequest request = new ExchangeActivityRuleSaveRequest();
        BeanCopier.create(param, request).copy();
        return exchangeClient.createRule(request);
    }

    @Override
    public Response<Long> modifyRule(ExchangeActivityRuleSaveParam param) {
        ExchangeActivityRuleSaveRequest request = new ExchangeActivityRuleSaveRequest();
        BeanCopier.create(param, request).copy();
        return exchangeClient.modifyRule(request);
    }

    @Override
    public Response<ExchangeActivityResponse> info(Long activityId) {
        return exchangeClient.info(activityId);
    }

    @Override
    public Response purchaseHistory(ExchangeActivityParam param) {
        return null;
    }

    @Override
    public Response goodsRule(ExchangeActivityParam param) {
        return null;
    }

    @Override
    public Response goodsRuleInfo(Long activityId, Long goodsId) {
        return null;
    }
}
