package quick.pager.shop.param.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolePageParam extends PageParam {
    private static final long serialVersionUID = 7463357139222297502L;

    /**
     * 角色名称
     */
    private String roleName;

}
