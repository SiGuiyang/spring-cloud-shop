package quick.pager.shop.activity.request.assemble;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.request.PageRequest;

/**
 * 拼团PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AssemblePageRequest extends PageRequest {
    private static final long serialVersionUID = -5329561098615911834L;

    private String activityName;

    private String activityImg;

    private String createUser;

    private Long goodsId;

    private Long activityId;

    private Long ruleId;

    private Long recordId;

    private Integer purchaseLimit;

    private Integer assembleCount;

    private String description;

    /**
     * 查询的时间范围
     */
    private List<LocalDateTime> timeRange;
}
