package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupRecord extends Model {

    private static final long serialVersionUID = -626383581837906008L;

    private Long activityId;

    private Integer status;
}
