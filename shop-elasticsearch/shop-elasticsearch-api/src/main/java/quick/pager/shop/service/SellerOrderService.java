package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.elasticsearch.request.ESSellerOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESSellerOrderResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商户订单服务
 *
 * @author siguiyang
 */
public interface SellerOrderService {
    /**
     * 商户订单列表
     *
     * @param request 请求参数
     */
    Response<List<ESSellerOrderResponse>> queryPage(final ESSellerOrderPageRequest request);
}
