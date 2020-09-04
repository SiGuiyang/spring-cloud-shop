package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 角色权限
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_role_menu")
public class RoleMenu extends Model {
    private static final long serialVersionUID = 5296292799500727996L;
    /**
     * 角色主键
     */
    private Long roleId;
    /**
     * 权限编码
     */
    private String permission;


}
