package quick.pager.shop.user.param;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.AppDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsCartParam extends AppDTO {
    private static final long serialVersionUID = 8839566920448410731L;

    private List<Long> goodsIds;

    private Integer goodsCount;
}
