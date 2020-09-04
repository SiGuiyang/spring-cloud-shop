package quick.pager.shop.goods.response.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPropertyResponse extends BasicResponse {
    private static final long serialVersionUID = -1548086988584429677L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 属性组主键
     */
    private Long propertyGroupId;
    /**
     * 属性名称
     */
    private String propertyName;
    /**
     * 属性组名称
     */
    private String propertyGroupName;
}
