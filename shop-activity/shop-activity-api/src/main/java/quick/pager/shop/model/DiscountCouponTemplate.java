package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 优惠券模板
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_discount_coupon_template")
public class DiscountCouponTemplate extends Model {

    private static final long serialVersionUID = 1608002644741787377L;

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
    private Boolean state;
    /**
     * 券模版类型
     *
     * @see quick.pager.shop.activity.enums.CouponTypeEnums
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
    /**
     * 开始时间
     */
    private LocalDate beginTime;
    /**
     * 结束时间
     */
    private LocalDate endTime;

}
