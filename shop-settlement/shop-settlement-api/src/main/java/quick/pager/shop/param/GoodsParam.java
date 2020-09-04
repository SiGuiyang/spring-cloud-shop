package quick.pager.shop.param;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车商品明细
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsParam extends Param {
    private static final long serialVersionUID = 1012530220733336415L;

    /**
     * 购买商品主键
     */
    private Long goodsId;
    /**
     * 购买商品数量
     */
    private Integer purchaseQuantity;
    /**
     * 购买商品价格
     */
    private BigDecimal goodsAmount;
}
