package quick.pager.shop.activity.request.coupon;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 优惠券PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponPageRequest extends PageRequest {
    private static final long serialVersionUID = 7596667898732568306L;

    private String couponName;

    private String phone;

    private Integer discountType;

    private List<LocalDateTime> timeRange;

}
