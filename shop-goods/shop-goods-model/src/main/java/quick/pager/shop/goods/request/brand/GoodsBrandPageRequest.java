package quick.pager.shop.goods.request.brand;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.PageRequest;

/**
 * GoodsBrandPageRequest
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsBrandPageRequest extends PageRequest {
    private static final long serialVersionUID = 8251378580124843900L;

    private String brandName;

    private List<LocalDateTime> dateTimes;
}
