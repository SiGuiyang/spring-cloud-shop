package quick.pager.shop.manage.param.exchange;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 满赠换购规则
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRuleSaveParam extends Param {
    private static final long serialVersionUID = 6418241272626616227L;

    private Long id;

    /**
     * t_exchange_activity id
     */
    private Long activityId;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 购买商品满足的金额条件下限
     */
    private BigDecimal orderAmount;
}
