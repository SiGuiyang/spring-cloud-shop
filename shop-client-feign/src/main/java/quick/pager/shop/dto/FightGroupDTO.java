package quick.pager.shop.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupDTO extends ManageDTO {
    private static final long serialVersionUID = -5329561098615911834L;

    @NotNull(message = "活动名称不能为空")
    private String activityName;
    @NotNull(message = "活动图片不能为空")
    private String activityImg;

    private String createUser;

    private Long goodsId;

    private Long activityId;

    private Long ruleId;

    private Long recordId;

    private Integer purchaseLimit;

    private Integer fightCount;

    private String description;
}
