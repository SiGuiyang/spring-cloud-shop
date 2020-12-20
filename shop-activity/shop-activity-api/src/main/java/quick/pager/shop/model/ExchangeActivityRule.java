package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
     * t_activity id
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
