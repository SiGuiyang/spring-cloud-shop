package quick.pager.shop.model.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品sku
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_sku")
public class GoodsSku extends Model {

    private static final long serialVersionUID = 1L;

    private Long spuId;

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
     * 默认的sku，显示在列表的主sku商品 true, false
     */
    private Boolean defaultSku;

    /**
     * 商品状态 0 未上架 1 上架申请 2 上架 3 已下架
     */
    private Integer skuStatus;

    /**
     * 商品重量
     */
    private BigDecimal weight;

    /**
     * 商品单位，比如kg
     */
    private String unit;


}
