package quick.pager.shop.param.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 角色保存Param
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleSaveParam extends Param {
    private static final long serialVersionUID = 7463357139222297502L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 是否超级管理员
     */
    private Boolean master;
}
