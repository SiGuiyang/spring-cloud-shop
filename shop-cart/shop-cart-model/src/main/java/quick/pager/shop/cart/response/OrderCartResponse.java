package quick.pager.shop.cart.response;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 通过购物车，生成商品明细列表
 *
 * @author siguiyang
 */
@Data
public class OrderCartResponse implements Serializable {
    private static final long serialVersionUID = 2287274452626822362L;

    /**
     * 商品主键
     */
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片
     */
    private String goodsImage;
    /**
     * 商品原价格
     */
    private BigDecimal goodsAmount;
    /**
     * 商品折扣价格
     */
    private BigDecimal discountAmount;
    /**
     * 购买商品数量
     */
    private Integer quantity;

}
