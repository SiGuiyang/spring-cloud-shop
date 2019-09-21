package quick.pager.shop.model.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 购买成功的商品购物车与订单之间的关系
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BuyerGoodsCart extends Model {
    private static final long serialVersionUID = -6259943969547659036L;

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
