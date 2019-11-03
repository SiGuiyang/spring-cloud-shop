package quick.pager.shop.model.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品属性组
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_property_group")
public class GoodsPropertyGroup extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 商品属性 t_goods_property id
     */
    private Long propertyId;

    private String propertyGroupName;


}
