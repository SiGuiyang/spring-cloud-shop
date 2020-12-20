package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员账户
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("t_user_account")
public class UserAccount extends Model {
    private static final long serialVersionUID = -2307902197537773932L;

    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 积分数量
     */
    private Integer integral;
}
