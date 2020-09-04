package quick.pager.shop.activity.response.assemble;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 拼团规则
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleActivityRuleResponse extends BasicResponse {

    private static final long serialVersionUID = 217286657393813092L;

    private Long id;
    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 状态
     */
    private Boolean serverStatus;
    /**
     * 限购次数
     */
    private Integer purchaseLimit;
    /**
     * 成团人数
     */
    private Integer assembleCount;
    /**
     * 说明
     */
    private String description;
}
