package quick.pager.shop.model.cart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 购物车
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsCart extends Model {

    private static final long serialVersionUID = 710965017625429252L;
    /**
     * 购买的用户
     */
    private Long userId;
    /**
     * 购买的商品
     */
    private Long goodsId;
    /**
     * 购买商品的数量
     */
    private Integer goodsCount;
}
