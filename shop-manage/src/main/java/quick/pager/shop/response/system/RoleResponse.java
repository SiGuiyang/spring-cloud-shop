package quick.pager.shop.response.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 角色
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleResponse extends BasicResponse {

    private static final long serialVersionUID = -4660253489132506580L;

    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 是否是超级管理员
     */
    private Boolean master;
}
