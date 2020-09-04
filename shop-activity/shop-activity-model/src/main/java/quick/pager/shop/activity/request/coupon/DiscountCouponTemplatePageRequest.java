package quick.pager.shop.activity.request.coupon;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 优惠券模板PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponTemplatePageRequest extends PageRequest {
    private static final long serialVersionUID = -4545073771563223799L;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String templateName;

    private String description;
}
