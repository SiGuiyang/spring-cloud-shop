package quick.pager.shop.param;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsCartParam extends Param {
    private static final long serialVersionUID = 8839566920448410731L;

    private List<Long> goodsIds;

    private Integer goodsCount;
}
