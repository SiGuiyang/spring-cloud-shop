package quick.pager.shop.goods.request.sku;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.PageRequest;

/**
 * 商品sku 分页
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSkuPageRequest extends PageRequest {
    private static final long serialVersionUID = -1755038601656015483L;
}
