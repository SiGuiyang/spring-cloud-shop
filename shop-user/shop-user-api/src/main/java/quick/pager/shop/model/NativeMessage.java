package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 站内信
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_native_message")
public class NativeMessage extends Model {

    private static final long serialVersionUID = 1354022482374239056L;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 当前登陆人手机号码
     */
    private String phone;
    /**
     * 站内信内容
     */
    private String content;
    /**
     * 站内信状态
     */
    private Integer status;
}
