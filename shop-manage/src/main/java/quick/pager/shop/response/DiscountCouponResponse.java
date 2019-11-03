package quick.pager.shop.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponResponse extends BasicResponse {
    private static final long serialVersionUID = -1183285822481432970L;

    private Long userId;

    private Long templateId;

    private String phone;

    private Boolean used;

    private BigDecimal orderAmount;

    private BigDecimal couponAmount;

    private BigDecimal discountStrength;

    private Integer templateType;

    private String templateName;

    private String description;

    private Date beginTime;

    private Date endTime;

}
