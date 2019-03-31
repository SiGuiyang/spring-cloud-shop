package quick.pager.shop.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDTO extends ManageDTO {
    private static final long serialVersionUID = 2802879969759895845L;

    private String sysName;

    private String username;

    private String password;

    private List<Long> roleIds;

    private String avatar;

    private String loginCode;

}
