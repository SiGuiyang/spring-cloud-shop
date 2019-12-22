package quick.pager.shop.manage.param.coupon;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 优惠券模板
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DiscountCouponTemplatePageParam extends PageParam {
    private static final long serialVersionUID = -3110502562099202503L;

    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 模板类型
     */
    private Integer templateType;
}
