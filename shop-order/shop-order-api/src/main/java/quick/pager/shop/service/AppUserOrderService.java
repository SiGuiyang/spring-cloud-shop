package quick.pager.shop.service;

import quick.pager.shop.order.request.SubmitOrderRequest;
import quick.pager.shop.order.response.AppUserOrderResponse;
import quick.pager.shop.param.AppUserOrderEvaluateParam;
import quick.pager.shop.order.response.UserOrderQuantityResponse;
import quick.pager.shop.user.response.Response;

/**
 * App订单服务
 *
 * @author siguiyang
 */
public interface AppUserOrderService {
    /**
     * 订单气泡数
     *
     * @param userId 当前用户登陆主键
     */
    Response<UserOrderQuantityResponse> quantity(final Long userId);

    /**
     * 订单列表
     *
     * @param userId    当前用户登陆主键
     * @param page      页码
     * @param order 订单类型
     */
    Response<AppUserOrderResponse> orders(final Long userId, final Integer page, final String order);

    /**
     * 订单详情
     *
     * @param userId  当前用户登陆主键
     * @param orderId 订单主键
     */
    Response detail(final Long userId, final Long orderId);

    /**
     * 订单评价
     *
     * @param userId  当前用户登陆主键
     * @param orderId 订单主键
     * @param param   订单评价内容
     */
    Response evaluate(Long userId, Long orderId, AppUserOrderEvaluateParam param);

    /**
     * 订单取消
     *
     * @param userId  当前用户登陆主键
     * @param orderId 订单主键
     */
    Response cancel(final Long userId, final Long orderId);

    /**
     * 用户订单退款
     *
     * @param userId  当前用户登陆主键
     * @param orderId 订单主键
     */
    Response refund(final Long userId, final Long orderId);

    /**
     * 用户订单确认收货
     *
     * @param userId  当前用户登陆主键
     * @param orderId 订单主键
     */
    Response confirm(final Long userId, final Long orderId);

    /**
     * 用户提交订单
     *
     * @param request 请求对象
     * @return 响应对象
     */
    Response submit(final SubmitOrderRequest request);
}
