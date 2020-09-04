package quick.pager.shop.platform.request.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * FormPageRequest
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormPageRequest extends PageRequest {
    private static final long serialVersionUID = -6984222441885803742L;

    /**
     * 表单模型
     */
    private String bizType;
    /**
     * 表单模型名称
     */
    private String name;
}
