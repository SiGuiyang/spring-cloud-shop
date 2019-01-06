package quick.pager.shop.model.manage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends Model {

    private static final long serialVersionUID = 6227594831283103430L;

    private String sysName;

    private String sysCode;

    private String password;

    private String roleCode;

    private String avatar;

    private String createUser;

}