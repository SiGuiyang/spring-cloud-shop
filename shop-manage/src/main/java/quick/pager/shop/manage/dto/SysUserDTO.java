package quick.pager.shop.manage.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDTO extends DTO {
    private static final long serialVersionUID = 2802879969759895845L;

    private String sysName;

    private String sysCode;

    private String password;

    private List<String> roleCode;

    private String avatar;

}
