package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityMembers extends Model {
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
     * 手机号码
     */
    private String phone;
    private java.util.Date updateTime;
    private java.util.Date createTime;
    private Boolean deleteStatus;
}
