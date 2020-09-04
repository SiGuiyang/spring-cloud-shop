package quick.pager.shop.platform.request.sms;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 短信发送请求
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SMSRequest extends Request {
    private static final long serialVersionUID = 6787169876401808776L;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 事件源
     */
    private String event;
}
