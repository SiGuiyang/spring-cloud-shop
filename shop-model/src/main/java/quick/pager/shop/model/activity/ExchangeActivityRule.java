package quick.pager.shop.model.activity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_exchange_activity_rule")
public class ExchangeActivityRule extends Model {
    private static final long serialVersionUID = -6238358371738961355L;
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
