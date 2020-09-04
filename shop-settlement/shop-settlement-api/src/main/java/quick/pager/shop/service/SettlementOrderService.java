package quick.pager.shop.service;

import quick.pager.shop.param.SettlementParam;
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
     * @param param 请求参数
     * @return 返回响应消息
     */
    Response<String> check(final SettlementParam param);

    /**
     * 清结算生产订单
     *
     * @param param 业务处理参数
     * @return 返回响应消息
     */
    Response<String> createOrder(final SettlementParam param);
}
