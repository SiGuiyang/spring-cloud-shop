package quick.pager.shop.param.coupon;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 用户优惠券
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserCouponParam extends PageParam {
    private static final long serialVersionUID = -2296317392896099571L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 使用方式
     * 未使用: nonUse
     * 已使用: used
     * 已过期: expire
     */
    private String useType;

}
