package quick.pager.shop.goods.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartDTO extends DTO {
    private static final long serialVersionUID = -6591856362210499785L;
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 商品id集合
     */
    private List<Long> goodsIds;
}
