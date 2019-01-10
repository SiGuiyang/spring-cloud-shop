package quick.pager.shop.activity.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CouponResponse implements Serializable{
    private static final long serialVersionUID = 9121464674006896865L;

    /**
     * 数据库主键
     */
    private Long id;

    private String couponName;

    private String phone;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer discountType;
    // 剩余过期天数
    private Integer remainExpireDate;
    // 1 未使用 2 已使用 3 已过期
    private Integer operationType;

    private Date beginTime;

    private Date endTime;

    private String description;
}
