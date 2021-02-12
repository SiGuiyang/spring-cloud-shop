package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 活动主类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_activity")
public class Activity extends Model {

    private static final long serialVersionUID = 8816387730047149630L;

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
     *
     * @see quick.pager.shop.activity.enums.ActivityTypeEnums
     */
    private Integer activityType;
    /**
     * 活动状态
     */
    private Boolean state;
    /**
     * 开始时间
     */
    private LocalDateTime beginTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;

}
