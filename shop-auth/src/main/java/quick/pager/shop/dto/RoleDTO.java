package quick.pager.shop.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -4866078202042386120L;
    private String roleName;

    private String roleCode;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
