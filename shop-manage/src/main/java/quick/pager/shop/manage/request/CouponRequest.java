package quick.pager.shop.manage.request;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponRequest extends ManageRequest {
    private static final long serialVersionUID = 6678905351148377916L;

    private String couponName;

    private Integer discountType;

    private Date beginTime;

    private Date endTime;

}
