package quick.pager.shop.activity.response.coupon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 优惠券模板Response
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponTemplateResponse extends BasicResponse {

    private static final long serialVersionUID = -933831985929429982L;
    /**
     * 业务主键
     */
    private Long id;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 右击金额
     */
    private BigDecimal couponAmount;

    /**
     * 折扣力度
     */
    private BigDecimal discountStrength;
    /**
     * 模板类型
     */
    private Integer templateType;
    /**
     * 模板类型名称
     */
    private Integer templateTypeName;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 说明
     */
    private String description;

    private Boolean serverStatus;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
}
