package quick.pager.shop.activity.response.coupon;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户优惠券
 *
 * @author siguiyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponResponse implements Serializable {
    private static final long serialVersionUID = 523470244932587364L;

    private Long id;
    /**
     * 优惠券名称
     */
    private String name;
    /**
     * 满减条件
     */
    private String condition;
    /**
     * 卡有效开始时间,时间戳, 单位秒
     */
    private Long startAt;
    /**
     * 卡失效日期 (时间戳, 单位秒)
     */
    private Long endAt;
    /**
     * 描述信息，优惠券可用时展示
     */
    private String description;
    /**
     * 不可用原因，优惠券不可用时展示
     */
    private String reason;
    /**
     * 折扣券优惠金额，单位分
     */
    private BigDecimal value;
    /**
     * 折扣券优惠金额文案
     */
    private String valueDesc;
    /**
     * 单位文案
     */
    private String unitDesc;
}
