package quick.pager.shop.goods.param;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartParam extends AppDTO {
    private static final long serialVersionUID = -6591856362210499785L;
    /**
     * 商品id
     */
    private List<Long> goodsIds;
    /**
     * 购买商品的数量
     */
    private Integer goodsCount;
}
