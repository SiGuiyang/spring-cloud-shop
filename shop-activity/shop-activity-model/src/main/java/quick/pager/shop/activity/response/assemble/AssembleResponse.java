package quick.pager.shop.activity.response.assemble;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleResponse extends BasicResponse {
    private static final long serialVersionUID = 6305729641911049557L;

    private Long id;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动图片
     */
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
