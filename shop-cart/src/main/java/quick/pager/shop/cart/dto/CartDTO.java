package quick.pager.shop.cart.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class CartDTO extends DTO {
    private static final long serialVersionUID = -6591856362210499785L;

    private Long userId;
}
