package quick.pager.shop.goods.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPageRequest extends PageRequest {
    private static final long serialVersionUID = -861392038879822891L;

    /**
     * 商品分类主键
     */
    private Long goodsClassId;
    /**
     * 商品主表名称
     */
    private String keyword;
    /**
     * 商品状态 0 上架申请 1 审核通过  2 审核拒绝
     * @see quick.pager.shop.goods.enums.GoodsPublishStatusEnum
     */
    private Integer publishStatus;
    /**
     * 商品类型
     */
    private Integer goodsType;
    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Boolean goodsState;
    /**
     * 商品状态 0 未上架 1 上架
     */
    private Boolean state;
    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    private Boolean recommend;
}
