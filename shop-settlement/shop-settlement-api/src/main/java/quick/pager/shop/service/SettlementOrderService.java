package quick.pager.shop.service;

import quick.pager.shop.settlement.request.SettlementCheckRequest;
import quick.pager.shop.settlement.request.SettlementRequest;
import quick.pager.shop.settlement.request.SettlementSubmitRequest;
import quick.pager.shop.settlement.response.SettlementSkuResponse;
import quick.pager.shop.user.response.Response;

/**
 * 订单清结算
 *
 * @author siguiyang
 */
public interface SettlementOrderService {

    /**
     * 验证结算数据是否正确
     *
     * @param request 请求参数
     * @return 返回响应消息
     */
    Response<SettlementSkuResponse> check(final SettlementCheckRequest request);

    /**
     * 清结算生产订单
     *
     * @param request 业务处理参数
     * @return 返回响应消息
     */
    Response<Long> createOrder(final SettlementRequest request);

    /**
     * 支付成功后主动调用
     * 更新订单状态并记录三方支付的订单号
     *
     * @param request 请求参数
     */
    Response<Long> submit(final SettlementSubmitRequest request);
}
