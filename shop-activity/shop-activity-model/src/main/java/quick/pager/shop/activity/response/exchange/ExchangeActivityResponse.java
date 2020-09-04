package quick.pager.shop.activity.response.exchange;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * 满赠换购
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExchangeActivityResponse extends BasicResponse {
    private static final long serialVersionUID = 1160417053081709146L;

    private Long id;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动图片
     */
    private String activityImg;

    private Boolean serverStatus;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

}
