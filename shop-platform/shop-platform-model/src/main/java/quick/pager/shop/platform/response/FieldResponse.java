package quick.pager.shop.platform.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.response.BasicResponse;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FieldResponse extends BasicResponse {
    private static final long serialVersionUID = -1290367219009062121L;

    /**
     * 字段类型
     */
    private String type;
    /**
     * 字段标题
     */
    private String title;
    /**
     * 字段值
     */
    private Object value;
    /**
     * 布局
     */
    private ColResponse col = new ColResponse();
    /**
     * 字段属性
     */
    private FieldPropsResponse props;
}
