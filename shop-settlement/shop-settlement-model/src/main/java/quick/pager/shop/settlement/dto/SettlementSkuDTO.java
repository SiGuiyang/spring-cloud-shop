package quick.pager.shop.settlement.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 结算sku商品
 *
 * @author siguiyang
 */
@Data
public class SettlementSkuDTO implements Serializable {
    private static final long serialVersionUID = 505278105672262472L;

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
}
