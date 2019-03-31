package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends ManageDTO {
    private static final long serialVersionUID = 7463357139222297502L;

    private String roleName;

    private String roleCode;

}
