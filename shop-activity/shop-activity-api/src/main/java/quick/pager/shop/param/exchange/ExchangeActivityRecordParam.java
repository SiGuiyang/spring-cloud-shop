package quick.pager.shop.param.exchange;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 满赠换购
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRecordParam extends Param {
    private static final long serialVersionUID = 2007199083630273862L;

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
