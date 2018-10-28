package quick.pager.shop.seller.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.response.Response;

/**
 * 商家服务
 *
 * @author siguiyang
 */
@RestController
public class SellerController {

    /**
     * 登陆
     */
    @PostMapping("/seller/login")
    public Response login() {
        return null;
    }

    /**
     * 注册
     */
    @PostMapping("/seller/subscribe")
    public Response subscribe() {
        return null;
    }

    /**
     * 商家信息
     */
    @PostMapping("/seller/info")
    public Response sellerInfo() {
        return null;
    }
}
