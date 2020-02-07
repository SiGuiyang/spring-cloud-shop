package quick.pager.shop.manage.response.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.manage.model.Role;
import quick.pager.shop.response.BasicResponse;

/**
 * 系统用户
 *
 * @author siguiyang
 * @version 3.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserResponse extends BasicResponse {

    private static final long serialVersionUID = 6313168677365244170L;
    /**
     * 登陆用户名
     */
    private String username;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 密码
     */
    private String password;

    private String avatar;

    @TableField(exist = false)
    private List<Role> roles = new ArrayList<>();
    @TableField(exist = false)
    private List<Long> roleIds = new ArrayList<>();

    private List<MenuResponse> routers = Lists.newArrayList();

    private List<String> permissions = Lists.newArrayList();
}
