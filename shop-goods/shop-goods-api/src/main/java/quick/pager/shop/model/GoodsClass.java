package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_class")
public class GoodsClass extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 商品spuId
     */
    private Long spuId;

    /**
     * 分类名称
     */
    private String className;

    /**
     * 序号
     */
    private Integer sequence;


}
