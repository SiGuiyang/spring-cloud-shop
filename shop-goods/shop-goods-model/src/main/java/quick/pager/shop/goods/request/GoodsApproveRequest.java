package quick.pager.shop.goods.request;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品审核请求对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GoodsApproveRequest extends Request {

    private static final long serialVersionUID = -2168039059805777597L;

    /**
     * 商品主键
     */
    private Long goodsId;
    /**
     * t_goods_sku id
     */
    private Long skuId;
    /**
     * 商品状态 0 未上架 1 上架申请 2 上架 3 已下架
     *
     * @see quick.pager.shop.goods.enums.GoodsPublishStatusEnum
     */
    private String publishStatus;
    /**
     * 拒绝说明
     */
    private String description;
}
