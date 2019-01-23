package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupRule extends Model {
    private static final long serialVersionUID = 827954724434418257L;

    private String activityName;

    private Long groupId;

    private Integer purchaseLimit;

    private Integer fightCount;

    private String description;

}