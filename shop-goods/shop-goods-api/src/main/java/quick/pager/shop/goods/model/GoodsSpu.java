package quick.pager.shop.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品spu
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_spu")
public class GoodsSpu extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 分类 t_goods_class id 这个分类必须是二级分类，不可是顶级分类
     */
    private Long classId;

    /**
     * spu 名称
     */
    private String spuName;

    /**
     * spu 图片
     */
    private String spuImage;

    /**
     * 序号
     */
    private Integer sequence;

}
