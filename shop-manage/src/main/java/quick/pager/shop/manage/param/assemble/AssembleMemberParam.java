package quick.pager.shop.manage.param.assemble;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 拼团成员
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleMemberParam extends PageParam {
    private static final long serialVersionUID = 1226973700079456769L;

    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 手机号码
     */
    private String phone;
}
