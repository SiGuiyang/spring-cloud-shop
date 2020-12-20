package quick.pager.shop.cart.request;

import java.io.Serializable;
import lombok.Data;

/**
 * 购物车
 *
 * @author siguiyang
 */
@Data
public class CartRequest implements Serializable {
    private static final long serialVersionUID = -8307353865247178933L;
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
}
