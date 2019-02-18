package quick.pager.shop.auth.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDTO extends ManageDTO {
    private static final long serialVersionUID = 2802879969759895845L;

    private String sysName;

    private String sysCode;

    private String password;

    private List<Long> roleIds;

    private String avatar;

    private String loginCode;

}
