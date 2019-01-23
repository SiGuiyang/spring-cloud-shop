package quick.pager.shop.model.feign.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupRequest extends ManageRequest {
    private static final long serialVersionUID = -5329561098615911834L;

    private String activityName;

    private String activityImg;

    private String createUser;

    private Long goodsId;

    private Long groupId;

    private Long ruleId;

    private Long recordId;

    private Integer purchaseLimit;

    private Integer fightCount;

    private String description;
}
