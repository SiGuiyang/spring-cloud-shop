package quick.pager.shop.goods.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartDTO extends AppDTO {
    private static final long serialVersionUID = -6591856362210499785L;

    /**
     * 商品id集合
     */
    private List<Long> goodsIds;
}
