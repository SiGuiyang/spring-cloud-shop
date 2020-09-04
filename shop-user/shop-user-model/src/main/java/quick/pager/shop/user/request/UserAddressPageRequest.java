package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户地址列表
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAddressPageRequest extends PageRequest {
    private static final long serialVersionUID = 2067945755714531151L;
    /**
     * 用户主键
     */
    private Long userId;
}
