package quick.pager.shop.cart.response;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 购物车列表
 *
 * @author siguiyang
 */
@Data
public class GoodsCartResponse implements Serializable {
    private static final long serialVersionUID = 1660182360445628070L;

    /**
     * 购物车主键
     */
    private Long id;
    /**
     * 商品sku主键
     */
    private Long skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品图片名称
     */
    private String skuImage;
    /**
     * 购买数量
     */
    private Integer quantity;
    /**
     * sku原价
     */
    private BigDecimal skuAmount;
    /**
     * 折扣价格
     */
    private BigDecimal discountAmount;
    /**
     * false 表示sku未失效
     * true 表示sku失效
     */
    private Boolean expire;
}
