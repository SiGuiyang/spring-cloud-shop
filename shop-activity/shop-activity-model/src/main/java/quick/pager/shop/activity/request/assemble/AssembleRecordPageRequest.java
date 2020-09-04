package quick.pager.shop.activity.request.assemble;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 拼团记录
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleRecordPageRequest extends PageRequest {
    private static final long serialVersionUID = -4414340422176840509L;
    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 手机号码
     */
    private String phone;
}
