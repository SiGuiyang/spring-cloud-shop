package quick.pager.shop.activity.request.coupon;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 发布优惠券
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PublishCouponRequest extends Request {
    private static final long serialVersionUID = 1890447832247125669L;
    /**
     * 文件路径地址
     */
    private String file;
    /**
     * 模板主键
     */
    private Long templateId;
}
