package quick.pager.shop.feign.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class CouponRequest extends ManageRequest {
    private static final long serialVersionUID = 6678905351148377916L;

    private String couponName;

    private String phone;

    private Integer discountType;

}
