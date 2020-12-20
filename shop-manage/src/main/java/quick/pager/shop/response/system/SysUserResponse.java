package quick.pager.shop.response.system;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Role;
import quick.pager.shop.user.response.BasicResponse;

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
     * 主键
     */
    private Long id;
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

    /**
     * 0 ：正常 1：禁用
     */
    private Boolean state;

    private String avatar;

    private List<Role> roles = new ArrayList<>();

    private List<MenuResponse> routers = Lists.newArrayList();

    private List<String> permissions = Lists.newArrayList();
}
