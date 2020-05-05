package quick.pager.shop.goods.request.sku;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.ImageModel;
import quick.pager.shop.request.Request;

/**
 * 商品sku
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSkuSaveRequest extends Request {
    private static final long serialVersionUID = -264146593818464682L;
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
    private Integer inventory;
    /**
     * 图片集
     */
    private List<ImageModel> images;
}
