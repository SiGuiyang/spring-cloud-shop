package quick.pager.shop.param;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车商品明细
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsCartParam extends Param {
    private static final long serialVersionUID = -9118054142979867878L;

    /**
     * 购买商品的所属商户主键
     */
    private Long sellerId;
    /**
     * 优惠券主键
     */
    private Long couponId;
    /**
     * 商品明细
     */
    private List<GoodsParam> goods;
}
