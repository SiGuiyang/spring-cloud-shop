package quick.pager.shop.activity.request.assemble;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleRuleSaveRequest extends Request {

    private static final long serialVersionUID = -795586465056396092L;

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
