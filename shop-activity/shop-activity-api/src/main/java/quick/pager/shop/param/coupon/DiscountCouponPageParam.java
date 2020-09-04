package quick.pager.shop.param.coupon;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponPageParam extends PageParam {
    private static final long serialVersionUID = 1982538063274395852L;

    private String phone;
    /** 时间周期 */
    private List<LocalDateTime> dateTimes;
}
