package quick.pager.shop.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

/**
 * 商品分类与商品品牌关联
 *
 * @author siguiyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_class_brand")
public class GoodsClassBrand extends Model {
    private static final long serialVersionUID = -2244080462046078314L;

    /**
     * 商品分类主键
     * t_goods_class id 这个分类必须是二级分类，不可是顶级分类
     */
    private Long goodsClassId;
    /**
     * 商品品牌主键
     */
    private Long goodsBrandId;
}
