package quick.pager.shop.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Model {

    private static final long serialVersionUID = 6874571522967825468L;

    private String phone;

    private String password;

    private Byte serverStatus;

}