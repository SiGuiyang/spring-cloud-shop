package quick.pager.shop.manage.param.coupon;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 用户优惠券
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponPageParam extends PageParam {
    private static final long serialVersionUID = -4461760634124440461L;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 周期
     */
    private List<LocalDateTime> timeRange;
}
