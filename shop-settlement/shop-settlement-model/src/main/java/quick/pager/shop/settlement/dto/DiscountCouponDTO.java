package quick.pager.shop.settlement.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

/**
 * 优惠券
 *
 * @author siguiyang
 */
@Data
public class DiscountCouponDTO implements Serializable {
    private static final long serialVersionUID = -848649447823898093L;

    /**
     * 数据库主键
     */
    private Long id;
    /**
     * 模版主键
     */
    private Long templateId;
    /**
     * 优惠券手机号
     */
    private String phone;
    /**
     * 优惠券模板名称
     */
    private String templateName;
    /**
     * 优惠券说明
     */
    private String description;
    /**
     * 满订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 优惠券金额
     */
    private BigDecimal discountAmount;
    /**
     * 折扣力度
     */
    private BigDecimal discountStrength;
    /**
     * 优惠券类型
     *
     * @see quick.pager.shop.activity.enums.CouponTypeEnums
     */
    private Integer templateType;
    /**
     * 开始时间
     */
    private LocalDate beginTime;
    /**
     * 结束时间
     */
    private LocalDate endTime;
}
