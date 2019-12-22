package quick.pager.shop.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页参数Param
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageParam extends Param {

    private static final long serialVersionUID = 4915406379328423571L;
    /**
     * 分页数大小
     */
    private Integer pageSize = 10;
    /**
     * 页码
     */
    private Integer page = 1;
}
