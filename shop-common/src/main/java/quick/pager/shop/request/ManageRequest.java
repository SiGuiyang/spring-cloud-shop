package quick.pager.shop.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManageRequest extends PageRequest {

    private static final long serialVersionUID = -5688667377694449671L;
    /**
     * 系统登陆名
     */
    private String sysCode;
    /**
     * 起始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;
}
