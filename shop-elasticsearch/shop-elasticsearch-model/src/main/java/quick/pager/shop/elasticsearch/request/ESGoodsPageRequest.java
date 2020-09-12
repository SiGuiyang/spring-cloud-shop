package quick.pager.shop.elasticsearch.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.enums.SortEnums;
import quick.pager.shop.user.request.PageRequest;

/**
 * 商品ES分页request
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ESGoodsPageRequest extends PageRequest {
    private static final long serialVersionUID = -872578209788826156L;

    /**
     * 检索关键字
     */
    private String keyword;

    /**
     * 用户主键
     */
    private Long userId;

    private Long goodsClassId;

    private String goodsName;
    /**
     * 排序
     */
    private SortEnums sort;

}
