package quick.pager.shop.goods.model;

import quick.pager.shop.model.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品品牌
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_goods_brand")
public class GoodsBrand extends Model {

    private static final long serialVersionUID = 1L;
    /**
     * t_goods_brand_group 主键
     */
    private Long brandGroupId;
    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌编码
     */
    private String brandCode;

    /**
     * 品牌图标
     */
    private String icon;

    /**
     * 序号
     */
    private Integer sequence;

}
