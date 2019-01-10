package quick.pager.shop.model.activity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

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