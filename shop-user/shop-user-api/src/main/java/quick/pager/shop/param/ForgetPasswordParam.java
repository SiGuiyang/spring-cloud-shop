package quick.pager.shop.param;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 忘记密码
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ForgetPasswordParam extends Param {
    private static final long serialVersionUID = -43319194565812207L;

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
    @NotBlank(message = "短信验证码不能为空")
    private String verifyCode;
}
