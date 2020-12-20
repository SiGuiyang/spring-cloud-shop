package quick.pager.shop.goods.response.sku;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import quick.pager.shop.goods.dto.GoodsSkuDTO;

/**
 * spu分类商品
 *
 * @author siguiyang
 */
@Data
public class AppGoodsSkuResponse implements Serializable {
    private static final long serialVersionUID = -7144817458143723311L;

    /**
     * 分类主键
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类下sku
     */
    private List<GoodsSkuDTO> skus;
}
