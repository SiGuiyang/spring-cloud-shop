package quick.pager.shop.model.seller;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class Seller extends Model {

    private static final long serialVersionUID = 8487325370020125166L;
    private String phone;

    private String password;

}