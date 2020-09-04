package quick.pager.shop.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 用户地址列表
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAddressPageParam extends PageParam {
    private static final long serialVersionUID = 2067945755714531151L;
    /**
     * 用户主键
     */
    private Long userId;
}
