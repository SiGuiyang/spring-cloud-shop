package quick.pager.shop.manage.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_sys_user")
public class SysUser extends Model {

    private static final long serialVersionUID = 6227594831283103430L;

    // 登陆用户名
    private String username;
    // 手机号码
    private String phone;
    // 密码
    private String password;

    private String avatar;

    @TableField(exist = false)
    private List<Role> roles = new ArrayList<>();
    @TableField(exist = false)
    private List<Long> roleIds = new ArrayList<>();

}
