package quick.pager.shop.activity.response.exchange;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 满赠换购记录
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityRecordResponse extends BasicResponse {
    private static final long serialVersionUID = -1678317923612840067L;

    private Long id;
    /**
     * t_exchange_activity id
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * pager_shop中 t_user 的id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * pager_goods中t_goods 的id
     */
    private Long goodsId;
    /**
     * 商品名称（sku名称）
     */
    private String goodsName;
    /**
     * t_exchange_activity_rule id
     */
    private Long ruleId;
    /**
     * 活动规则名称
     */
    private String ruleName;
    /**
     * 手机号码
     */
    private String phone;

}
