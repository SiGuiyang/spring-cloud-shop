package quick.pager.shop.user.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.AppDTO;
import quick.pager.common.dto.BaseDTO;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ForgetPasswordDTO extends AppDTO {
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
    private String verifyCode;
}
