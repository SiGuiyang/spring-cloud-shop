package quick.pager.shop.manage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends DTO {
    private static final long serialVersionUID = 7463357139222297502L;

    private String roleName;

    private String roleCode;

}
