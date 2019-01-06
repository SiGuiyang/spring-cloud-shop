package quick.pager.shop.model.manage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolePermission extends Model {

    private static final long serialVersionUID = -7311624118026385915L;

    private Long roleId;

    private Long permissionId;

}