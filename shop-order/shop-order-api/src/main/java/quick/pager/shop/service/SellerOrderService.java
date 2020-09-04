package quick.pager.shop.service;

import quick.pager.shop.order.request.SellerOrderSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 商户订单
 *
 * @author siguiyang
 */
public interface SellerOrderService {
    /**
     * 创建商户订单
     */
    Response create(SellerOrderSaveRequest request);
}
