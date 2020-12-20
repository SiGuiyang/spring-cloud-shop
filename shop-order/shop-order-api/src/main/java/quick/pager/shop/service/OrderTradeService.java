package quick.pager.shop.service;

import quick.pager.shop.order.request.OrderTradeSaveRequest;
import quick.pager.shop.user.response.Response;

/**
 * 订单交易流水
 *
 * @author siguiyang
 */
public interface OrderTradeService {

    /**
     * 新增
     *
     * @param request 请求参数
     * @return 返回数据
     */
    Response<Long> create(final OrderTradeSaveRequest request);
}
