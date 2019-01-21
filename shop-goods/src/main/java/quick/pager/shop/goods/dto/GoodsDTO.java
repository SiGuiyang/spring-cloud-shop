package quick.pager.shop.goods.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDTO extends DTO {
    private static final long serialVersionUID = -4450878746485911231L;

    private Integer pageSize;

    private Integer page;
}
