package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
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

}
