package quick.pager.shop.controller.app;

import java.util.List;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.enums.AppCouponUseTypeEnum;
import quick.pager.shop.activity.response.coupon.CouponResponse;
import quick.pager.shop.service.AppDiscountCouponService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

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
     *
     * @param userId  用户主键
     * @param page    页码
     * @param useType 使用方式，UNUSED：未使用， USED：已使用，EXPIRE：已过期
     * @see quick.pager.shop.activity.enums.AppCouponUseTypeEnum
     */
    @PostMapping("/app/user/coupons/{userId}/{page}/{useType}")
    public Response<List<CouponResponse>> coupons(@PathVariable("userId") Long userId,
                                                  @PathVariable("page") Integer page,
                                                  @PathVariable("useType") String useType) {

        return appDiscountCouponService.queryCoupons(userId, page, EnumUtils.getEnum(AppCouponUseTypeEnum.class, useType));
    }
}
