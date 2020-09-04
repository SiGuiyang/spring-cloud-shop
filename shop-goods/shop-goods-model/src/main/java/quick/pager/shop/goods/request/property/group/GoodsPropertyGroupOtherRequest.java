package quick.pager.shop.goods.request.property.group;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 属性组
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertyGroupOtherRequest extends Request {
    private static final long serialVersionUID = 7592551387983131271L;

    /**
     * 属性组名称
     */
    private String propertyGroupName;
}
