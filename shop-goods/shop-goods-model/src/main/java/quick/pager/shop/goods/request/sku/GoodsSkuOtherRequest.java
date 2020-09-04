package quick.pager.shop.goods.request.sku;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 商品sku检索
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSkuOtherRequest extends Request {
    private static final long serialVersionUID = 4142738456666068299L;
    /**
     * 商品sku 主键集
     */
    private List<Long> ids;

}
