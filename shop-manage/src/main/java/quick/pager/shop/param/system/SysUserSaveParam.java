package quick.pager.shop.param.system;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserSaveParam extends Param {
    private static final long serialVersionUID = 2802879969759895845L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 昵称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 0 ：正常 1：禁用
     */
    private Boolean state;
    private List<Long> roleIds;

    private String avatar;

    private String loginCode;

}
