package quick.pager.shop.activity.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityOtherRequest extends Request {
    private static final long serialVersionUID = -139718301733182632L;

    private String keyword;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 查询的时间范围
     */
    private List<LocalDateTime> range;
}
