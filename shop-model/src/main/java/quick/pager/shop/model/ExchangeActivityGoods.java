package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityGoods extends Model {
    /**
     * t_exchange_activity id
     */
    private Long acticityId;
    /**
     * t_exchange_activity_rule id
     */
    private Long ruleId;
    /**
     * pager_goods中t_goods 的id
     */
    private Long goodsId;
    private java.util.Date updateTime;
    private java.util.Date createTime;
    private Boolean deleteStatus;
}
