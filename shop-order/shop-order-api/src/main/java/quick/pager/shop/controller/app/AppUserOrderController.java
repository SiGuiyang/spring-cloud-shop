package quick.pager.shop.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.order.request.SubmitOrderRequest;
import quick.pager.shop.order.response.AppUserOrderResponse;
import quick.pager.shop.param.AppUserOrderEvaluateParam;
import quick.pager.shop.order.response.UserOrderQuantityResponse;
import quick.pager.shop.service.AppUserOrderService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.util.AuthUtils;

/**
 * App 用户订单
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class AppUserOrderController {

    @Autowired
    private AppUserOrderService appUserOrderService;

    /**
     * App 用户订单头部气泡数
     */
    @PostMapping("/app/quantity")
    public Response<UserOrderQuantityResponse> quantity() {

        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.quantity(principal.getId());
    }

    /**
     * App 用户订单列表
     *
     * @param page  页码
     * @param order 订单类型
     */
    @PostMapping("/app/{page}/{order}")
    public Response<AppUserOrderResponse> orders(@PathVariable("page") Integer page,
                                                 @PathVariable("order") String order) {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.orders(principal.getId(), page, order);
    }

    /**
     * App 用户订单详情
     *
     * @param orderId 订单主键
     */
    @PostMapping("/app/{orderId}/detail")
    public Response detail(@PathVariable("orderId") Long orderId) {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.detail(principal.getId(), orderId);
    }

    /**
     * App 用户订单评价
     *
     * @param orderId 订单主键
     */
    @PostMapping("/app/{orderId}/evaluate")
    public Response evaluate(@PathVariable("orderId") Long orderId,
                             @RequestBody AppUserOrderEvaluateParam param) {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.evaluate(principal.getId(), orderId, param);
    }

    /**
     * App 用户订单取消
     *
     * @param orderId 订单主键
     */
    @PostMapping("/app/{orderId}/cancel")
    public Response cancel(@PathVariable("orderId") Long orderId) {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.cancel(principal.getId(), orderId);
    }

    /**
     * App 用户订单退款
     *
     * @param orderId 订单主键
     */
    @PostMapping("/app/{orderId}/refund")
    public Response refund(@PathVariable("orderId") Long orderId) {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.refund(principal.getId(), orderId);
    }

    /**
     * App 用户订单确认收货
     *
     * @param orderId 订单主键
     */
    @PostMapping("/app/{orderId}/confirm")
    public Response confirm(@PathVariable("orderId") Long orderId) {
        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appUserOrderService.confirm(principal.getId(), orderId);
    }

    /**
     * App 用户提交订单
     *
     * @param request 请求参数
     */
    @PostMapping("/app/submit")
    public Response submit(@RequestBody SubmitOrderRequest request) {
        return appUserOrderService.submit(request);
    }
}
