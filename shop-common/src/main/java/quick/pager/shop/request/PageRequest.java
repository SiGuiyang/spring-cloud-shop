package quick.pager.shop.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageRequest extends Request {
    private static final long serialVersionUID = -8989796076245602142L;

    /**
     * 一页的数量
     */
    private Integer pageSize = 10;
    /**
     * 页码
     */
    private Integer page = 0;
}
