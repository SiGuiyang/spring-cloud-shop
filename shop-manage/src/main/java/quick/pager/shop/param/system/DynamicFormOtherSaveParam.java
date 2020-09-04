package quick.pager.shop.param.system;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class DynamicFormOtherSaveParam implements Serializable {

    private static final long serialVersionUID = 8039056869216274413L;
    /**
     * 表单内容
     */

    private List<DynamicFormParam> widgets;

    /**
     * 业务类型
     */
    private String bizType;
}
