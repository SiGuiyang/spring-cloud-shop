package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 参与满赠换购的人员
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_exchange_activity_member")
public class ExchangeActivityMember extends Model {
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
