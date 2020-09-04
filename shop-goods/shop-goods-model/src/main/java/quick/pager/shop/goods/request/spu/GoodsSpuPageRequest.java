package quick.pager.shop.goods.request.spu;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 商品spu 分页
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSpuPageRequest extends PageRequest {
    private static final long serialVersionUID = -4144846306668353162L;

    /**
     * spu名称
     */
    private String spuName;
}
