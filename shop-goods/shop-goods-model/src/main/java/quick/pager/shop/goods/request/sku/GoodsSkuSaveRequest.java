package quick.pager.shop.goods.request.sku;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.Request;

/**
 * 商品sku
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSkuSaveRequest extends Request {
    private static final long serialVersionUID = -264146593818464682L;
}
