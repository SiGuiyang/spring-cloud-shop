package quick.pager.shop.model.activity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class FightGroupGoods extends Model {

    private static final long serialVersionUID = 8176754461106350259L;

    private Long goodsId;

    private Long groupId;

    private Long ruleId;

}