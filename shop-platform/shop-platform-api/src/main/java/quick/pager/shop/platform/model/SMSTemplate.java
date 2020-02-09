package quick.pager.shop.platform.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class SMSTemplate extends Model {

    private static final long serialVersionUID = -2264345466177697910L;

    /**
     * 所属模块
     */
    private String module;
    /**
     * 模板标识
     */
    private String smsTemplateCode;
    /**
     * 模板内容
     */
    private String smsTemplateContent;

}
