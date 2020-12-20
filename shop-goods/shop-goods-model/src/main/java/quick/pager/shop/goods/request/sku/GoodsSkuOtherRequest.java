package quick.pager.shop.goods.request.sku;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 商品sku检索
 *
 * @author siguiyang
 */
@Data
public class GoodsSkuOtherRequest implements Serializable {
    private static final long serialVersionUID = 4142738456666068299L;
    /**
     * 商品sku 主键集
     */
    private List<Long> ids;

}
