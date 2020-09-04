package quick.pager.shop.platform.request.sms;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 短信模板 PageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SMSTemplatePageRequest extends PageRequest {
    private static final long serialVersionUID = -6861845088669194884L;

    /**
     * 所属模块
     */
    private String module;
    /**
     * 模板标识
     */
    private String smsTemplateCode;
}
