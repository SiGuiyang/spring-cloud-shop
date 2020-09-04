package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品主图集
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_sku_image")
public class GoodsSkuImage extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主表主键
     */
    private Long goodsId;
    /**
     * 商品t_goods_sku id
     */
    private Long skuId;

    /**
     * 图片路径，存储方式为json格式[{"imageUrl": "/123/abc/2001.png", "master": true},{"imageUrl": "/123/abc/2001.png" , "master": false}]
     */
    private String images;


}
