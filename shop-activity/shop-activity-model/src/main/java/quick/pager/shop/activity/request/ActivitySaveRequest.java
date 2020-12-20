package quick.pager.shop.activity.request;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 主活动saveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivitySaveRequest extends Request {
    private static final long serialVersionUID = 3791235339164864448L;

    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动主图
     */
    private String activityImg;
    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 活动状态
     */
    private Boolean state;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;
}
