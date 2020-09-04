package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 表单模型
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_form")
public class Form extends Model {
    private static final long serialVersionUID = 8942888563648861086L;
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
