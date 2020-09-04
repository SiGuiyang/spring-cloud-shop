package quick.pager.shop.cart.response;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 购物车条目
 *
 * @author siguiyang
 */
@Data
public class GoodsCartDetailResponse implements Serializable {
    private static final long serialVersionUID = -1499723444581929834L;

    /**
     * 商品sku主键
     */
    private Long skuId;
    /**
     * 购物车主键
     */
    private Long goodsCartId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品图片名称
     */
    private String skuLogo;
    /**
     * 购买数量
     */
    private Integer quantity;
    /**
     * 商品名称
     */
    private BigDecimal skuAmount;


}
