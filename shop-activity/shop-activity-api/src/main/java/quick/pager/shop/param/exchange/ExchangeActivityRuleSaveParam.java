package quick.pager.shop.param.exchange;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 满赠换购规则
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRuleSaveParam extends Param {
    private static final long serialVersionUID = 6084702038191682697L;

    private Long id;
    /**
     * 活动主键
     */
    private Long activityId;
}
