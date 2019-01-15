package quick.pager.shop.manage.request;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserRequest extends ManageRequest {
    private static final long serialVersionUID = -8196973040453095480L;

    private String sysName;

    private String sysCode;

    private String loginCode;

    private String password;

    private List<Long> roleIds;

    private String avatar;

    private Integer serverStatus;
}
