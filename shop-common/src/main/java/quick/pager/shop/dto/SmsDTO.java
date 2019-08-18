package quick.pager.shop.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信公共服务数据对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsDTO extends BaseDTO {

    private static final long serialVersionUID = 6004420887746924633L;

    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;
    @ApiModelProperty(value = "发送短信事件源", required = true)
    private String source;
    @ApiModelProperty(value = "图形验证码", required = false)
    private String graphicCode;

    private String content;

}
