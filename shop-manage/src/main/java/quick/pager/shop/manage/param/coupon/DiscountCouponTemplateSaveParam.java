package quick.pager.shop.manage.param.coupon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 优惠券模板
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponTemplateSaveParam extends Param {
    private static final long serialVersionUID = -6135744437584424308L;

    private Long id;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String templateName;

    private String description;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;
}
