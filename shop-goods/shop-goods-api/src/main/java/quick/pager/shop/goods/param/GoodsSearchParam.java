package quick.pager.shop.goods.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSearchParam extends AppDTO {
    private static final long serialVersionUID = -5201517264758579637L;

    private Long goodsClassId;

    private String goodsName;


}
