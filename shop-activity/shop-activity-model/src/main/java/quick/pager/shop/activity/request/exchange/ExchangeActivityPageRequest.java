package quick.pager.shop.activity.request.exchange;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 满赠换购PageRequest
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityPageRequest extends PageRequest {

    private static final long serialVersionUID = -2139790759429948078L;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 查询的时间范围
     */
    private List<LocalDateTime> timeRange;

}
