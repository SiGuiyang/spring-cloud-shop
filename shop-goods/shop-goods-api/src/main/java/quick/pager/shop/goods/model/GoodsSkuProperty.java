package quick.pager.shop.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品sku 与商品属性组关联关系表
多对多关系
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_sku_property")
public class GoodsSkuProperty extends Model {

    private static final long serialVersionUID = 1L;

    private Long skuId;

    /**
     * t_goods_property_group id
     */
    private Long propertyGroupId;


}
