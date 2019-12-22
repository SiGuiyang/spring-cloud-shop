package quick.pager.shop.manage.param.system;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationParam extends ManageDTO {

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
