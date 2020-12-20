package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 黑名单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_risk_whitelist")
public class Whitelist extends Model {
    private static final long serialVersionUID = -274385051893807072L;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 禁用 true ，启用 false
     */
    private Boolean state;
}
