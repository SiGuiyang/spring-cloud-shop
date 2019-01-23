package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupRecord extends Model {

    private static final long serialVersionUID = -626383581837906008L;

    private Long groupId;
}