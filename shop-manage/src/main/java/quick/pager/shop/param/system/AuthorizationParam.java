package quick.pager.shop.param.system;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationParam extends Param {

    private static final long serialVersionUID = 4399880937415097395L;
    /**
     * 权限
     */
    private List<Long> permissions;
    /**
     * 角色主键
     */
    private Long roleId;
}
