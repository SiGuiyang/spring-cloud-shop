package quick.pager.shop.response;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRuleResponse extends BasicResponse {
    private static final long serialVersionUID = -3102864042731704193L;
    /**
     * t_exchange_activity id
     */
    private Long activityId;
    /**
     * 规则名称
     */
    private String ruleName;

    private String activityName;

    /**
     * 购买商品满足的金额条件下限
     */
    private BigDecimal orderAmount;
}
