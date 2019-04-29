package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupRule extends Model {
    private static final long serialVersionUID = 827954724434418257L;

    private String activityName;

    private Long activityId;

    private Integer purchaseLimit;

    private Integer fightCount;

    private String description;

}
