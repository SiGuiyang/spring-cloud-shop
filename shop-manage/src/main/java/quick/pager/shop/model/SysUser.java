package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统登陆用户
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_sys_user")
public class SysUser extends Model {

    private static final long serialVersionUID = 6227594831283103430L;

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

    /**
     * true 超级管理员
     */
    private Boolean beAdmin;
    /**
     * 头像
     */
    private String avatar;

}
