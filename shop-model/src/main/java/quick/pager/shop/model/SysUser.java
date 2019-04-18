package quick.pager.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseUser {

    private static final long serialVersionUID = 6227594831283103430L;

    private String sysName;

    private String avatar;

    private String createUser;

    private List<Role> roles = new ArrayList<>();

    private List<Long> roleIds = new ArrayList<>();

}
