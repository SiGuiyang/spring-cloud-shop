package quick.pager.shop.activity.request.exchange;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 满赠换购SaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivitySaveRequest extends Request {

    private static final long serialVersionUID = -2139790759429948078L;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动图片
     */
    private String activityImg;

    /**
     * 开始时间
     */
    private LocalDateTime beginTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;

}
