package quick.pager.shop.feign.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponTemplateDTO extends ManageDTO {
    private static final long serialVersionUID = -4545073771563223799L;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String templateName;

    private String description;
}
