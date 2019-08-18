package quick.pager.shop.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponTemplateDTO extends ManageDTO {
    private static final long serialVersionUID = -4545073771563223799L;

    @NotBlank(message = "订单金额不能为空")
    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    @Size(min = 0, max = 1, message = "优惠券类型必须0或者1")
    private Integer templateType;
    @NotBlank(message = "优惠券模块名称不能为空")
    private String templateName;

    private String description;
}
