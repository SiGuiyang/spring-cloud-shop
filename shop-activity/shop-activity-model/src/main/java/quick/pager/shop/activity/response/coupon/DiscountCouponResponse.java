package quick.pager.shop.activity.response.coupon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 优惠券
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponResponse extends BasicResponse {
    private static final long serialVersionUID = -6781079386405136237L;
    /**
     * 数据库主键
     */
    private Long id;

    private Long userId;

    private Long templateId;

    private String phone;

    private String username;

    private String templateName;

    private String description;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

}
