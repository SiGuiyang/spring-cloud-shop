package quick.pager.shop.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.user.response.Response;

/**
 * APP 商户订单
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ORDER)
public class AppSellerOrderController {

    /**
     * 商户订单列表
     *
     * @return
     */
    @GetMapping("/app/seller/{sellerId}/list")
    public Response list(@PathVariable("sellerId") Long sellerId) {
        return null;
    }
}
