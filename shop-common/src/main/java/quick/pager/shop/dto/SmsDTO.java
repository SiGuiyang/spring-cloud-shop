package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信公共服务数据对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsDTO extends BaseDTO {

    private static final long serialVersionUID = 6004420887746924633L;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 发送短信事件源
     */
    private String source;
    /**
     * 图形验证码
     */
    private String graphicCode;
    /**
     * 短信内容
     */
    private String content;

}
