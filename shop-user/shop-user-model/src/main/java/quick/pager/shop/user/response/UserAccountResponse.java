package quick.pager.shop.user.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户账户
 *
 * @author siguiyang
 */
@Data
public class UserAccountResponse implements Serializable {
    private static final long serialVersionUID = 8890085366618920692L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 积分数量
     */
    private Integer integral;
}
