package quick.pager.shop.model.activity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCoupon extends Model {

    private static final long serialVersionUID = -5526569535126804716L;
    private Long userId;

    private Long templateId;

    private String couponName;

    private BigDecimal orderAmount;

    private BigDecimal discountAmount;

    private Integer discountType;

    private Date beginTime;

    private Date endTime;

    private String description;

}