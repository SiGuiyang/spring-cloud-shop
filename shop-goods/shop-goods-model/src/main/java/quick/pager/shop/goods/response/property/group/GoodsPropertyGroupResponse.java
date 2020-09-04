package quick.pager.shop.goods.response.property.group;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商品属性组
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertyGroupResponse extends BasicResponse {
    private static final long serialVersionUID = -6273283144166377067L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 商品属性组名称
     */
    private String propertyGroupName;
}
