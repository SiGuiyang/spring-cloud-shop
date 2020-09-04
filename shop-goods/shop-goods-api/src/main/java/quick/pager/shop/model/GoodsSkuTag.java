package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品sku tag标签
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_sku_tag")
public class GoodsSkuTag extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主表主键
     */
    private Long goodsId;
    /**
     * 商品t_goods_sku id
     */
    private Long skuId;
    /**
     * 标签名称
     */
    private String name;

}
