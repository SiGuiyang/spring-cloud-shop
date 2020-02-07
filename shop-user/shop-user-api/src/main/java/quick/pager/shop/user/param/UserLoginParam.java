package quick.pager.shop.user.param;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登陆
 */
@Data
public class UserLoginParam implements Serializable {
    private static final long serialVersionUID = -8483169592580367377L;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 短信验证码
     */
    private String verifyCode;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 图形验证码
     */
    private String graphicCode;

}
