package quick.pager.shop.manage.param.assemble;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 拼团规则
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleRuleSaveParam extends Param {

    private static final long serialVersionUID = -1214331576173592939L;

    private Long id;
    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 购买限制人数
     */
    private Integer purchaseLimit;
    /**
     * 成团人数
     */
    private Integer assembleCount;
    /**
     * 描述
     */
    private String description;
}
