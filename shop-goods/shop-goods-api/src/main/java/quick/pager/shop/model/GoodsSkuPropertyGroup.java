package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品sku与商品属性组property_group 关联表
 * 多对多关系
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_sku_property_group")
public class GoodsSkuPropertyGroup extends Model {

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
     * 商品属性组主键
     */
    private Long propertyGroupId;

}
