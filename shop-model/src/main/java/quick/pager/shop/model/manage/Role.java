package quick.pager.shop.model.manage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends Model {

    private static final long serialVersionUID = -7967826509330583583L;

    private String roleName;

    private String roleCode;

    private String createUser;

}