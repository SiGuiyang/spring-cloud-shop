package quick.pager.shop.platform.request.sms;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 短信模板 OtherRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SMSTemplateOtherRequest extends Request {
    private static final long serialVersionUID = -1193816585049439442L;
}
