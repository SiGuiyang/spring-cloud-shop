package quick.pager.shop.response;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleResponse extends BasicResponse {
    private static final long serialVersionUID = 6305729641911049557L;

    private String activityName;

    private String activityImg;

    private Long goodsId;

    private Long activityId;

    private Long ruleId;

    private Long recordId;

    private Integer purchaseLimit;

    private Integer assembleCount;

    private String description;

    private Date beginTime;

    private Date endTime;
}
