package quick.pager.shop.activity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_discount_coupon_template")
public class DiscountCouponTemplate extends Model {

    private static final long serialVersionUID = 1608002644741787377L;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String templateName;

    private String description;

    private Boolean serverStatus;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

}
