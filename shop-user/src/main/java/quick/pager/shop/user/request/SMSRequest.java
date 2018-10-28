package quick.pager.shop.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.request.Request;

/**
 * 发送短信请求类
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class SMSRequest extends Request {
    private static final long serialVersionUID = -1531901309703063825L;

    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;

    @ApiModelProperty(value = "业务信息", required = true)
    private String event;
}
