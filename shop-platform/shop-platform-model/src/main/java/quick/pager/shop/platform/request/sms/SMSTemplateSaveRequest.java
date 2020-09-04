package quick.pager.shop.platform.request.sms;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * 短信模板 SaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SMSTemplateSaveRequest extends Request {
    private static final long serialVersionUID = -6298599570494118858L;
}
