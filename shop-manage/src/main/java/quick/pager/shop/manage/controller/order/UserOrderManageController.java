package quick.pager.shop.manage.controller.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.manage.param.order.UserOrderPageParam;
import quick.pager.shop.response.Response;

/**
 * 用户订单管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class UserOrderManageController {

    /**
     * 用户订单列表
     */
    @PostMapping("/order/user")
    public Response order(@RequestBody UserOrderPageParam param) {
        return null;
    }

    /**
     * 用户订单详情
     */
    @PostMapping("/order/user/info")
    public Response orderInfo(@RequestParam("orderId") Long orderId) {
        return null;
    }
}
