package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityMembers extends Model {
    private static final long serialVersionUID = 3892197950124914263L;
    /**
     * t_exchange_activity id
     */
    private Long activityId;
    /**
     * pager_shop中 t_user 的id
     */
    private Long userId;
    /**
     * pager_goods中t_goods 的id
     */
    private Long goodsId;
    /**
     * t_exchange_activity_rule id
     */
    private Long ruleId;
    /**
     * 手机号码
     */
    private String phone;
}
