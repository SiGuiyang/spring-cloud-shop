package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_sys_user")
public class SysUser extends BaseUser {

    private static final long serialVersionUID = 6227594831283103430L;

    private String avatar;

    @TableField(exist = false)
    private List<Role> roles = new ArrayList<>();
    @TableField(exist = false)
    private List<Long> roleIds = new ArrayList<>();

}
