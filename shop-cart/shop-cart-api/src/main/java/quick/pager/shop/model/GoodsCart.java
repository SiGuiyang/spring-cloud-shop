package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>用户添加购物车</p>
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_goods_cart")
public class GoodsCart extends Model {

    private static final long serialVersionUID = 5264764014218925294L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 冗余商户主键
     */
    private Long sellerId;
    /**
     * 商品sku主键
     */
    private Long skuId;
    /**
     * 购买数量
     */
    private Integer quantity;
}
