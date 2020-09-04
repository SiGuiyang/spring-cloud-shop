package quick.pager.shop.goods.request.property.group;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品属性组
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertyGroupSaveRequest extends Request {
    private static final long serialVersionUID = -2840715863458020004L;

    /**
     * 属性组主键
     */
    private Long propertyGroupId;
    /**
     * 属性组名称
     */
    private String propertyGroupName;
}
