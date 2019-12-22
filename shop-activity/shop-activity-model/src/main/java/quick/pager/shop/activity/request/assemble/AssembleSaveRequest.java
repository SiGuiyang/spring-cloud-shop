package quick.pager.shop.activity.request.assemble;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.Request;

/**
 * 拼团SaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleSaveRequest extends Request {
    private static final long serialVersionUID = -5329561098615911834L;

    private String activityName;

    private String activityImg;

    private Long goodsId;

    private Long activityId;

    private Long ruleId;

    private Long recordId;

    /**
     * 周期
     */
    private List<LocalDateTime> timeRange;
}
