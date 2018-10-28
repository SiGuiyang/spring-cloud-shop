package quick.pager.shop.user.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 注册请求对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubscribeRequest extends Request {
    private static final long serialVersionUID = -4210066581336079652L;

    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;
    @ApiModelProperty(value = "短信验证码", required = true)
    private String verifyCode;
    @ApiModelProperty("图形验证码")
    private String graphicCode;
}
