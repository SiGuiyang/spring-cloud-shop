package quick.pager.shop.activity.request.coupon;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 优惠券SaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponSaveRequest extends Request {
    private static final long serialVersionUID = 7596667898732568306L;

    private String couponName;

    private String phone;

    private Integer discountType;

    private Date beginTime;

    private Date endTime;

}
