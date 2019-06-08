package quick.pager.shop.model.goods;

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
     * 购买商品购物车Id 与订单表一一对应<br />
     * 与购物车表一对多关系
     */
    private Long buyCartId;
    /**
     * 购买的商品
     */
    private Long goodsId;
    /**
     * 购买商品的数量
     */
    private Integer goodsCount;
}
