package quick.pager.shop.cart.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class CartDTO extends DTO {
    private static final long serialVersionUID = -6591856362210499785L;
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 购物车的操作方式<br />
     * add 新增
     * sub 减少
     * delete 选中删除
     */
    private String operation;
    /**
     * 商品id集合
     */
    private List<Long> goodsIds;
}
