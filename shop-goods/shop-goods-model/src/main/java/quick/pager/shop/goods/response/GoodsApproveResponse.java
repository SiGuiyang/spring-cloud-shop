package quick.pager.shop.goods.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsApproveResponse implements Serializable {

    private static final long serialVersionUID = -3088514019336322316L;
    /**
     * 商品主键
     */
    private Long goodsId;
    /**
     * t_goods_sku id
     */
    private Long skuId;
    /**
     * 拒绝说明
     */
    private String description;
}
