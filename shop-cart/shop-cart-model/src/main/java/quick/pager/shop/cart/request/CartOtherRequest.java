package quick.pager.shop.cart.request;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 商品购物车
 *
 * @author siguiyang
 */
@Data
public class CartOtherRequest implements Serializable {
    private static final long serialVersionUID = 5666983421837988488L;

    /**
     * 商品购物车主键集
     */
    private List<Long> goodsCartIds;

}
