package quick.pager.shop.user.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 忘记密码
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ForgetPasswordRequest extends Request {
    private static final long serialVersionUID = -1207901588038874754L;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 旧密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 短信验证码
     */
    private String verifyCode;
}
