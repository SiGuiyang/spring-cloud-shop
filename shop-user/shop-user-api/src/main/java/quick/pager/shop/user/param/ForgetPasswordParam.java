package quick.pager.shop.user.param;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.AppDTO;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ForgetPasswordParam extends AppDTO {
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
