package quick.pager.shop.user.service;

import quick.pager.shop.response.Response;

public interface UserOrderService {


    /**
     * 订单列表
     */
    Response orders();

    /**
     * 订单详情
     *
     * @param orderId 订单Id
     */
    Response orderInfo(Long orderId);

    /**
     * 下单
     */
    Response createOrder();
}
