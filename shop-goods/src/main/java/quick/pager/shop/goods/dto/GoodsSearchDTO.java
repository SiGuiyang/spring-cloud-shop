package quick.pager.shop.goods.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSearchDTO extends AppDTO {
    private static final long serialVersionUID = -5201517264758579637L;

    private Long goodsClassId;

    private String goodsName;


}
