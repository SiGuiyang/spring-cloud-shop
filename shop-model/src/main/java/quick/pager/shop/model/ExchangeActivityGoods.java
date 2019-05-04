package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityGoods extends Model {
    private static final long serialVersionUID = 4035091690901248350L;
    /**
     * t_exchange_activity id
     */
    private Long activityId;
    /**
     * t_exchange_activity_rule id
     */
    private Long ruleId;
    /**
     * pager_goods中t_goods 的id
     */
    private Long goodsId;
}
