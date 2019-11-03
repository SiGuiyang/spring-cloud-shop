package quick.pager.shop.dto.activity;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssembleDTO extends ManageDTO {
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

    private Date beginTime;

    private Date endTime;
}
