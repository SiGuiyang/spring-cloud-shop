package quick.pager.shop.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDTO extends ManageDTO {
    private static final long serialVersionUID = 2802879969759895845L;

    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "用户名不能为空")
    private String username;

    private String password;

    private List<Long> roleIds;

    private String avatar;

    private String loginCode;

}
