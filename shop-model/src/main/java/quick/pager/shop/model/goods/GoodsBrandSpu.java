package quick.pager.shop.model.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌与商品spu关联关系表
多对多关系
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_brand_spu")
public class GoodsBrandSpu extends Model {

    private static final long serialVersionUID = 1L;

    private Long spuId;

    /**
     * t_goods_brand_group id
     */
    private Long brandGroupId;

}
