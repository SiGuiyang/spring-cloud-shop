package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsSearchDTO extends AppDTO {
    private static final long serialVersionUID = -5201517264758579637L;

    private Long goodsClassId;

    private String goodsName;


}
