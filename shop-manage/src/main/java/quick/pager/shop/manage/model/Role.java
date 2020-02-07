package quick.pager.shop.manage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

/**
 * 系统角色
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_role")
public class Role extends Model {

    private static final long serialVersionUID = -7967826509330583583L;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 是否是超级管理员
     */
    private Boolean master;

}
