package quick.pager.shop.model;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponTemplate extends Model {

    private static final long serialVersionUID = 1608002644741787377L;
    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String templateName;

    private String description;

    private String updateUser;

    private String createUser;

}