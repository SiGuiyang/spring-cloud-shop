package quick.pager.shop.controller.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.response.coupon.CouponResponse;
import quick.pager.shop.model.LoginUser;
import quick.pager.shop.service.AppDiscountCouponService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.util.AuthUtils;

/**
 * app 优惠券列表
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AppCouponController {

    @Autowired
    private AppDiscountCouponService appDiscountCouponService;

    /**
     * 用户优惠券列表
     */
    @PostMapping("/app/user/coupons")
    public Response<List<CouponResponse>> coupons() {

        LoginUser principal = (LoginUser) AuthUtils.getPrincipal().getPrincipal();
        return appDiscountCouponService.queryCoupons(principal.getId());
    }
}
