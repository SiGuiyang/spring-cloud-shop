package quick.pager.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.elasticsearch.client.ESUserOrderClient;
import quick.pager.shop.mapper.UserOrderMapper;
import quick.pager.shop.param.AppUserOrderEvaluateParam;
import quick.pager.shop.order.response.UserOrderQuantityResponse;
import quick.pager.shop.service.AppUserOrderService;
import quick.pager.shop.user.response.Response;

/**
 * AppUserOrderService 实现
 *
 * @author siguiyang
 */
@Service
public class AppUserOrderServiceImpl implements AppUserOrderService {

    @Autowired
    private ESUserOrderClient esUserOrderClient;

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public Response<UserOrderQuantityResponse> quantity(Long userId) {
        return null;
    }

    @Override
    public Response orders(Long userId, Integer page, String orderType) {
        return null;
    }

    @Override
    public Response detail(Long userId, Long orderId) {
        return null;
    }

    @Override
    public Response evaluate(Long userId, Long orderId, AppUserOrderEvaluateParam param) {
        return null;
    }

    @Override
    public Response cancel(Long userId, Long orderId) {
        return null;
    }

    @Override
    public Response refund(Long userId, Long orderId) {
        return null;
    }

    @Override
    public Response confirm(Long userId, Long orderId) {
        return null;
    }
}
