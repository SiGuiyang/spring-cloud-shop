package quick.pager.shop.manage.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponTemplateDTO extends DTO{
    private static final long serialVersionUID = -4545073771563223799L;

    private BigDecimal orderAmount;

    private BigDecimal discountAmount;

    private Integer templateType;

    private String templateName;

    private String description;
}
