package quick.pager.shop.goods.request.sku;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.PageRequest;

/**
 * 商品sku 分页
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSkuPageRequest extends PageRequest {
    private static final long serialVersionUID = -1755038601656015483L;

    /**
     * 商品主表主键
     */
    private Long goodsId;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * sku 编码
     */
    private String skuCode;
    /**
     * 默认的sku，显示在列表的主sku商品 true, false
     */
    private Boolean defaultSku;
    /**
     * 入库量，库存量
     */
    private Integer inventory;
}
