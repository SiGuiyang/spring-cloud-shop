package quick.pager.shop.activity.request.assemble;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleMemberPageRequest extends PageRequest {
    private static final long serialVersionUID = 9055356342609553780L;
    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 手机号码
     */
    private String phone;
}
