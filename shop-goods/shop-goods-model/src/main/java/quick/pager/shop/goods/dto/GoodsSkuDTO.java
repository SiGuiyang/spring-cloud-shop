package quick.pager.shop.goods.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品
 *
 * @author siguiyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsSkuDTO implements Serializable {
    private static final long serialVersionUID = -1992466687719786334L;

    /**
     * 商品sku主键
     */
    private Long skuId;
    /**
     * 分类主键
     */
    private Long goodsClassId;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * 说明
     */
    private String description;
    /**
     * 商品价格
     */
    private BigDecimal skuAmount;
    /**
     * 折扣价格
     */
    private BigDecimal discountAmount;
    /**
     * 商品图片
     */
    private String skuImage;
}
