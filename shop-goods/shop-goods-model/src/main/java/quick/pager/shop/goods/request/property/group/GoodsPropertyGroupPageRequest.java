package quick.pager.shop.goods.request.property.group;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 商品属性组分页
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertyGroupPageRequest extends PageRequest {
    private static final long serialVersionUID = 2042060147637151018L;

    /**
     * 属性组名称
     */
    private String propertyGroupName;
}
