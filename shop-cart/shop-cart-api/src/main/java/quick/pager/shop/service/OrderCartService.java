package quick.pager.shop.service;

import quick.pager.shop.cart.request.OrderCartSaveRequest;
import quick.pager.shop.cart.response.OrderCartResponse;
import quick.pager.shop.user.response.Response;

/**
 * 购物车生成订单商品信息
 *
 * @author siguiyang
 */
public interface OrderCartService {

    /**
     * 订单商品详情
     *
     * @param request 请求参数
     * @return 数据返回
     */
    Response<OrderCartResponse> orders(final OrderCartSaveRequest request);
}
