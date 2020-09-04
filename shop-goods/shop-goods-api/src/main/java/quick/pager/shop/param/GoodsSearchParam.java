package quick.pager.shop.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.enums.SortEnums;

/**
 * 商品搜索
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSearchParam extends PageParam {
    private static final long serialVersionUID = -5201517264758579637L;

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
