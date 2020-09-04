package quick.pager.shop.activity.response.assemble;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 评团活动
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleActivityResponse extends BasicResponse {

    private static final long serialVersionUID = 667289570471589920L;

    private Long id;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 服务状态
     */
    private Boolean serverStatus;
    /**
     * 活动图片
     */
    private String activityImg;
    /**
     * 活动开始时间
     */
    private LocalDateTime beginTime;
    /**
     * 活动结束时间
     */
    private LocalDateTime endTime;
}
