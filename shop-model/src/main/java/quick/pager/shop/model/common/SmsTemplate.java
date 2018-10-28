package quick.pager.shop.model.common;


import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class SmsTemplate extends Model {

    private static final long serialVersionUID = -2264345466177697910L;

    private String module;

    private String smsTemplateCode;

    private String smsTemplateContent;

}