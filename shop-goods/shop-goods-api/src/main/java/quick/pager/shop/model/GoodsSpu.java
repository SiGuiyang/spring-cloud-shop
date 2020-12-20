package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
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
