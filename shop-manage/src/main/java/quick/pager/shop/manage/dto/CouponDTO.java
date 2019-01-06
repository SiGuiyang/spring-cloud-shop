package quick.pager.shop.manage.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponDTO extends DTO{
    private static final long serialVersionUID = 7596667898732568306L;

    private String couponName;

    private Integer discountType;

    private Date beginTime;

    private Date endTime;


}
