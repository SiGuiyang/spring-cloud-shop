package quick.pager.shop.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsCartDTO extends AppDTO {
    private static final long serialVersionUID = 8839566920448410731L;

    private List<Long> goodsIds;

    private Integer goodsCount;
}
