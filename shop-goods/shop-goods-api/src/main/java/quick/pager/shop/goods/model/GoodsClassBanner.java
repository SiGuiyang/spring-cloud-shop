package quick.pager.shop.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 商品分类与Banner关联表
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_goods_class_banner")
public class GoodsClassBanner extends Model {
    private static final long serialVersionUID = 4578892676040024059L;

    /**
     * 分类主键
     */
    private Long classificationId;
    /**
     * banner 主键
     */
    private Long bannerId;
}
