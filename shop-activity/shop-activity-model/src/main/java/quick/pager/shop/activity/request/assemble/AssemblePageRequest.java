package quick.pager.shop.activity.request.assemble;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 拼团PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssemblePageRequest extends PageRequest {
    private static final long serialVersionUID = -5329561098615911834L;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动图片
     */
    private String activityImg;

    private Long goodsId;
    /**
     * 活动主键
     */
    private Long activityId;
    /**
     * 活动规则主键
     */
    private Long ruleId;

    private Long recordId;

    private Integer purchaseLimit;

    private Integer assembleCount;

    private String description;

    /**
     * 查询的时间范围
     */
    private List<LocalDateTime> timeRange;
}
