package quick.pager.shop.manage.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.ManageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleRequest extends ManageRequest {
    private static final long serialVersionUID = -6375156039748056069L;

    private String roleName;

    private String roleCode;

}
