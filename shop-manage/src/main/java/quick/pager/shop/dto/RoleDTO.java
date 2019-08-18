package quick.pager.shop.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends ManageDTO {
    private static final long serialVersionUID = 7463357139222297502L;

    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @NotBlank(message = "角色代码不能为空")
    private String roleCode;

}
