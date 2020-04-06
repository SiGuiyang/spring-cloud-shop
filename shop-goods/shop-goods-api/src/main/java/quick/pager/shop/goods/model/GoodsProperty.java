package quick.pager.shop.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_property")
public class GoodsProperty extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 属性组主键
     */
    private Long propertyGroupId;

    /**
     * 属性名称
     */
    private String propertyName;


}
