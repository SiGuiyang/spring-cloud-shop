package quick.pager.shop.platform.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * FormResponse
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormResponse extends BasicResponse {
    private static final long serialVersionUID = 3678840260043958292L;

    private Long id;
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
