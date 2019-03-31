package quick.pager.shop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.SellerLoginDTO;
import quick.pager.shop.dto.SellerSubscribeDTO;
import quick.pager.shop.response.Response;

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
    public Response login(SellerLoginDTO dto) {
        return new Response();
    }

    /**
     * 注册
     */
    @PostMapping("/subscribe")
    public Response subscribe(SellerSubscribeDTO dto) {
        return null;
    }

    /**
     * 商家信息
     */
    @PostMapping("/info")
    public Response sellerInfo() {
        return null;
    }
}
