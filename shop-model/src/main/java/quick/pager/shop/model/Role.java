package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends Model {

    private static final long serialVersionUID = -7967826509330583583L;

    private String roleName;

    private String roleCode;

    private String createUser;

}