package quick.pager.shop.seller.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.seller.model.SellerInfo;
import quick.pager.shop.response.Response;
import quick.pager.shop.seller.param.SellerLoginParam;
import quick.pager.shop.seller.param.SellerSubscribeParam;

/**
 * 商家服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.SELLER)
public class SellerController {

    /**
     * 登陆
     */
    @PostMapping("/login")
    public Response login(SellerLoginParam param) {
        return new Response();
    }

    /**
     * 注册申请
     */
    @PostMapping("/subscribe")
    public Response subscribe(SellerSubscribeParam param) {
        return null;
    }

    /**
     * 查询商家
     *
     * @param sellerId 商家Id
     */
    @PostMapping("/info/{sellerId}")
    public Response<SellerInfo> querySeller(@PathVariable("sellerId") Long sellerId) {
        return new Response<>();
    }
}
