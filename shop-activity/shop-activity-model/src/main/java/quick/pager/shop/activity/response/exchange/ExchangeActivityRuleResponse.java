package quick.pager.shop.activity.response.exchange;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 满赠换购规则
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRuleResponse extends BasicResponse {
    private static final long serialVersionUID = -3102864042731704193L;

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
     * 活动名称
     */
    private String activityName;

    /**
     * 购买商品满足的金额条件下限
     */
    private BigDecimal orderAmount;
    /**
     * true 禁用 false 启用
     */
    private Boolean state;
}
