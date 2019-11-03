package quick.pager.shop.model.goods;

import com.baomidou.mybatisplus.annotation.TableName;
import quick.pager.shop.model.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品库存表
库存单独抽取出来
用于后期扩展使用
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_stock")
public class GoodsSkuStock extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * t_goods_sku id
     */
    private Long skuId;

    /**
     * 商品库存
     */
    private Integer stock;


}
