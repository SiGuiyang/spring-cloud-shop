package quick.pager.shop.activity.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 活动主类响应
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityResponse extends BasicResponse {
    private static final long serialVersionUID = 8446988225819243294L;

    private Long id;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
