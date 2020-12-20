package quick.pager.shop.activity.request.exchange;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRuleSaveRequest extends Request {

    private static final long serialVersionUID = 1670644130695740864L;

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
    /**
     * true 禁用 false 启用
     */
    private Boolean state;
}
