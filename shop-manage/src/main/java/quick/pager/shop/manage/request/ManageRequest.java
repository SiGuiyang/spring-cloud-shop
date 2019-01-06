package quick.pager.shop.manage.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManageRequest extends Request {

    private static final long serialVersionUID = -5688667377694449671L;
    /**
     * 系统登陆名
     */
    private String sysCode;
    /**
     * 系统操作人
     */
    private String createUser;
    /**
     * 启用标志
     */
    private Boolean deleteStatus;
}
