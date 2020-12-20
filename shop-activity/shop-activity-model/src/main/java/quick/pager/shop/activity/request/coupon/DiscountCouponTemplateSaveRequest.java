package quick.pager.shop.activity.request.coupon;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 优惠券模板SaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponTemplateSaveRequest extends Request {
    private static final long serialVersionUID = -4545073771563223799L;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 优惠券金额
     */
    private BigDecimal couponAmount;
    /**
     * 折扣券折扣力度
     */
    private BigDecimal discountStrength;
    /**
     * 券模板状态
     */
    private Boolean serverStatus;
    /**
     * 券模版类型
     */
    private Integer templateType;
    /**
     * 券模板名称
     */
    private String templateName;
    /**
     * 备注说明
     */
    private String description;
}
