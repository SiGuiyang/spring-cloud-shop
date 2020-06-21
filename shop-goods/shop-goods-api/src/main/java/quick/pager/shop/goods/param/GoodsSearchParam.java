package quick.pager.shop.goods.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 商品搜索
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSearchParam extends Param {
    private static final long serialVersionUID = -5201517264758579637L;

    private Long goodsClassId;

    private String goodsName;


}
