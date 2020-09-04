package quick.pager.shop.activity.request.exchange;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 满赠换购分页参数
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRecordPageRequest extends PageRequest {
    private static final long serialVersionUID = -5833245800752351312L;

    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 规则主键
     */
    private Long ruleId;
    /**
     * 用户手机号码
     */
    private String phone;
}
