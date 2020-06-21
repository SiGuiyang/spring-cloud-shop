package quick.pager.shop.order.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.order.param.AppUserOrderEvaluateParam;
import quick.pager.shop.response.Response;

/**
 * App 用户订单
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class AppUserOrderController {

    /**
     * App 用户订单头部气泡数
     *
     * @param userId 用户主键
     * @return
     */
    @GetMapping("/app/order/${userId}/quantity")
    public Response quantity(@PathVariable("userId") Long userId) {

        return null;
    }

    /**
     * App 用户订单列表
     *
     * @param userId    用户主键
     * @param page      页码
     * @param orderType 订单类型
     * @return
     */
    @GetMapping("/app/order/${userId}/${page}/${orderType}")
    public Response orders(@PathVariable("userId") Long userId,
                           @PathVariable("page") Integer page,
                           @PathVariable("orderType") String orderType) {

        return null;
    }

    /**
     * App 用户订单详情
     *
     * @param userId  用户主键
     * @param orderId 订单主键
     * @return
     */
    @PostMapping("/app/order/${userId}/${orderId}/detail")
    public Response detail(@PathVariable("userId") Long userId,
                           @PathVariable("orderId") Long orderId) {

        return null;
    }

    /**
     * App 用户订单评价
     *
     * @param userId  用户主键
     * @param orderId 订单主键
     * @return
     */
    @PostMapping("/app/order/${userId}/${orderId}/evaluate")
    public Response evaluate(@PathVariable("userId") Long userId,
                             @PathVariable("orderId") Long orderId,
                             @RequestBody AppUserOrderEvaluateParam param) {

        return null;
    }

    /**
     * App 用户订单取消
     *
     * @param userId  用户主键
     * @param orderId 订单主键
     * @return
     */
    @PostMapping("/app/order/${userId}/${orderId}/cancel")
    public Response cancel(@PathVariable("userId") Long userId,
                           @PathVariable("orderId") Long orderId) {

        return null;
    }

    /**
     * App 用户订单退款
     *
     * @param userId  用户主键
     * @param orderId 订单主键
     * @return
     */
    @PostMapping("/app/order/${userId}/${orderId}/refund")
    public Response refund(@PathVariable("userId") Long userId,
                           @PathVariable("orderId") Long orderId) {

        return null;
    }

    /**
     * App 用户订单确认收货
     *
     * @param userId  用户主键
     * @param orderId 订单主键
     * @return
     */
    @PostMapping("/app/order/${userId}/${orderId}/confirm")
    public Response confirm(@PathVariable("userId") Long userId,
                            @PathVariable("orderId") Long orderId) {

        return null;
    }
}
