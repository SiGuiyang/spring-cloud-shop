package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品审核记录
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("t_goods_approve")
public class GoodsApprove extends Model {
    private static final long serialVersionUID = 4777676422210811274L;

    /**
     * 商品主表主键
     */
    private Long goodsId;
    /**
     * t_goods_sku id
     */
    private Long skuId;

    /**
     * 商品状态 0 上架申请 1 审核通过 2 审核拒绝
     *
     * @see quick.pager.shop.goods.enums.GoodsPublishStatusEnum
     */
    private Integer publishStatus;

    /**
     * 说明
     */
    private String description;
}
