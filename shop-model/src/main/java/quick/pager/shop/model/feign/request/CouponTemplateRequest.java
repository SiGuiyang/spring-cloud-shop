package quick.pager.shop.model.feign.request;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponTemplateRequest extends ManageRequest {
    private static final long serialVersionUID = 5444006304682789532L;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String description;

    private String templateName;

}
