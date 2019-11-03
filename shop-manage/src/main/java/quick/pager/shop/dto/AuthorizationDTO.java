package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationDTO extends ManageDTO {

    private static final long serialVersionUID = 4399880937415097395L;
    /**
     * 权限
     */
    private String permissions;
    /**
     * 角色主键
     */
    private Long roleId;
}
