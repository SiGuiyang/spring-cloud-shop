package quick.pager.shop.goods.request.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品属性
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertySaveRequest extends Request {
    private static final long serialVersionUID = -4080801990812508703L;

    /**
     * 属性组主键
     */
    private Long propertyGroupId;

    /**
     * 属性名称
     */
    private String propertyName;
}
