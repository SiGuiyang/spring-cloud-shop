package quick.pager.shop.user.param;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户开户
 */
@Data
public class UserSubscribeParam implements Serializable {

    private static final long serialVersionUID = -8039364080502495265L;

    /**
     * 短信验证码
     */
    private String verifyCode;
}
