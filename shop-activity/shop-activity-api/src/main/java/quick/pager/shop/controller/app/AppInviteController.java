package quick.pager.shop.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 好友邀请
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AppInviteController {

    /**
     * 详情
     *
     * @param userId 用户主键
     * @return
     */
    public Response info(@PathVariable("userId") Long userId) {
        return null;
    }

    /**
     * 邀新奖励列表
     *
     * @param userId 用户主键
     * @param page   页码
     * @param type   邀新奖励类型， COUPON：优惠券，INTEGRAL：积分
     * @return
     */
    @GetMapping("/app/invite/reward/{userId}/{page}/{type}")
    public Response reward(@PathVariable("userId") Long userId,
                           @PathVariable("page") Integer page,
                           @PathVariable("type") String type) {

        return null;
    }

    /**
     * 兑换邀请码
     *
     * @param userId 用户主键
     * @param code   邀请码
     * @return
     */
    @PostMapping("/app/invite/{userId}/{code}")
    public Response exchange(@PathVariable("userId") Long userId,
                             @PathVariable("code") String code) {

        return null;
    }

    /**
     * 好友邀新活动规则列表
     *
     * @return
     */
    @GetMapping("/app/invite/rule")
    public Response rule() {
        return null;
    }
}
