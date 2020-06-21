package quick.pager.shop.activity.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.resp.UserCouponResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;

/**
 * app 优惠券列表
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AppCouponController {


    /**
     * 用户优惠券列表
     *
     * @param userId  用户主键
     * @param page    页码
     * @param useType 使用方式，UNUSED：未使用， USED：已使用，EXPIRE：已过期
     * @return
     * @see quick.pager.shop.activity.enums.AppCouponUseTypeEnum
     */
    @GetMapping("/app/user/coupons/{userId}/{page}/{useType}")
    public Response<UserCouponResponse> coupons(@PathVariable("userId") Long userId,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("useType") String useType) {

        return null;
    }
}
