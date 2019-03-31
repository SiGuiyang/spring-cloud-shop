package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.UserInfoDTO;

/**
 * 用户开户
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserSubscribeDTO extends UserInfoDTO {

    private static final long serialVersionUID = -8039364080502495265L;

    /**
     * 图形验证码
     */
    private String graphicCode;

    /**
     * 短信验证码
     */
    private String verifyCode;
}
