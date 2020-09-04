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
    private static final long serialVersionUID = -6591856362210499785L;
    /**
     * 商品id
     */
    private List<Long> goodsIds;
    /**
     * 购买商品的数量
     */
    private Integer goodsCount;
}
