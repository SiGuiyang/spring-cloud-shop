package quick.pager.shop.order.service;

import quick.pager.shop.order.model.SellerOrder;
import quick.pager.shop.order.request.SellerOrderSaveRequest;
import quick.pager.shop.response.Response;

/**
 * 商户订单
 *
 * @author siguiyang
 */
public interface SellerOrderService {
    /**
     * 创建商户订单
     */
    Response sellerOrderCreate(SellerOrderSaveRequest request);
}
