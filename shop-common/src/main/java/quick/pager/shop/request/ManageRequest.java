package quick.pager.shop.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManageRequest extends LimitRequest {

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
     * 起始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 启用标志
     */
    private Boolean deleteStatus;
}
