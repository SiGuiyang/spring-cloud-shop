package quick.pager.shop.platform.request.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * FormSaveRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormSaveRequest extends Request {
    private static final long serialVersionUID = 7555375589474035153L;

    /**
     * 表单模型
     */
    private String bizType;
    /**
     * 表单模型名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}
