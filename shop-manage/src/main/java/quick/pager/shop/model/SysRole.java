package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 系统用户与角色关联表
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_sys_role")
public class SysRole extends Model {

    private static final long serialVersionUID = 8913616211754943405L;

    private Long roleId;

    private Long sysUserId;


}
