package quick.pager.shop.goods.request.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 商品属性
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertyPageRequest extends PageRequest {
    private static final long serialVersionUID = 5949753278809209297L;

    /**
     * 属性名称
     */
    private String propertyName;
    /**
     * 属性组主键
     */
    private Long propertyGroupId;
}
