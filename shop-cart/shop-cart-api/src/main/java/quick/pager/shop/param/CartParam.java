package quick.pager.shop.param;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CartParam extends Param {
    private static final long serialVersionUID = -8307353865247178933L;

    /**
     * 当前购物车的主键
     */
    private Long id;
    /**
     * 购物车主键集
     */
    private List<Long> ids;
    /**
     * 当前登陆人主键
     */
    private Long userId;
    /**
     * 商户主键
     */
    private Long sellerId;
    /**
     * 购买商品的主键
     */
    private Long skuId;
    /**
     * 购买商品的数量
     */
    private Integer quantity;
}
