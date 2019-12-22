package quick.pager.shop.manage.param.system;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleParam extends ManageDTO {
    private static final long serialVersionUID = 7463357139222297502L;

    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @NotBlank(message = "角色代码不能为空")
    private String roleCode;

}
