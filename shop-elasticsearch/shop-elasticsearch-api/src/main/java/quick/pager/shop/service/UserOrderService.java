package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.elasticsearch.request.ESUserOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESUserOrderResponse;
import quick.pager.shop.user.response.Response;

/**
 * 用户订单服务
 *
 * @author siguiyang
 */
public interface UserOrderService {

    /**
     * 用户订单
     *
     * @param request 请求参数
     */
    Response<List<ESUserOrderResponse>> queryPage(final ESUserOrderPageRequest request);
}
