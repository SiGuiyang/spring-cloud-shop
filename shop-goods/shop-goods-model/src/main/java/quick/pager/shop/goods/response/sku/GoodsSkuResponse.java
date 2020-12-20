package quick.pager.shop.goods.response.sku;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.goods.dto.UploadDTO;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 商品sku
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSkuResponse extends BasicResponse {
    private static final long serialVersionUID = -7661625816391166028L;

    private Long id;

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
     * 说明
     */
    private String description;
    /**
     * 商品状态 0 未上架 1 上架
     */
    private Boolean state;
    /**
     * false 表示sku未失效
     * true 表示sku失效
     */
    private Boolean expire = Boolean.FALSE;
    /**
     * 含重量
     */
    private BigDecimal weight;
    /**
     * 商品价格
     */
    private BigDecimal skuAmount;
    /**
     * 折扣价格
     */
    private BigDecimal discountAmount;
    /**
     * 默认的sku，显示在列表的主sku商品 true, false
     */
    private Boolean defaultSku;
    /**
     * 入库量，库存量
     */
    private Integer stock;
    /**
     * 图片集
     */
    private List<UploadDTO> images;

}
