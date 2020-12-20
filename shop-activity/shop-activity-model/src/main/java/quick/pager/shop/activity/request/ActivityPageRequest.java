package quick.pager.shop.activity.request;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import quick.pager.shop.user.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityPageRequest extends PageRequest {
    private static final long serialVersionUID = -3677312894217866062L;

    /**
     * 搜索关键字
     */
    private String keyword;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动类型
     *
     * @see quick.pager.shop.activity.enums.ActivityTypeEnums
     */
    private Integer activityType;
    /**
     * 活动状态
     */
    private Boolean state;

    /**
     * 查询的时间范围
     */
    private List<Date> range;


}
