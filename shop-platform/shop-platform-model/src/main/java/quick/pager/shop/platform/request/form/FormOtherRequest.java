package quick.pager.shop.platform.request.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

/**
 * FormOtherRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormOtherRequest extends Request {
    private static final long serialVersionUID = 7282045937427025651L;
    /**
     * 表单模型
     */
    private String bizType;
    /**
     * 表单模型名称
     */
    private String name;
}
