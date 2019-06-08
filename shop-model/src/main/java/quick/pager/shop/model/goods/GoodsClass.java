package quick.pager.shop.model.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsClass extends Model {
    private static final long serialVersionUID = -125347438891842545L;

    private String className;

    private String icon;

    private String createUser;

}
