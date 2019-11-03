package quick.pager.shop.model.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品sku与商品属性组property_group 关联表
多对多关系
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

    private Long skuId;

    private Long propertyGroupId;

}
