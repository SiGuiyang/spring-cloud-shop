package quick.pager.shop.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 登陆请求对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class LoginRequest extends Request {
    private static final long serialVersionUID = 4771097621038456119L;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
    /**
     * 短信验证码
     */
    @ApiModelProperty(value = "短信验证码")
    private String verifyCode;
    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "登陆密码")
    private String password;
    /**
     * 图形验证码
     */
    @ApiModelProperty(value = "图形验证码")
    private String graphicCode;
}
