package quick.pager.shop.service;

import quick.pager.shop.model.order.SellerOrder;
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
    Response sellerOrderCreate(SellerOrder sellerOrder);
}
