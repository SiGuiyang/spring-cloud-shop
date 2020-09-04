package quick.pager.shop.goods.request.brand;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

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

    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌编码
     */
    private String brandCode;

    private List<LocalDateTime> dateTimes;
}
