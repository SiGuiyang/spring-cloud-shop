package quick.pager.shop.manage.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponTemplateRequest extends ManageRequest {
    private static final long serialVersionUID = 5444006304682789532L;

    private BigDecimal orderAmount;

    private BigDecimal discountAmount;

    private Integer templateType;

    private String description;

    private String templateName;

}
