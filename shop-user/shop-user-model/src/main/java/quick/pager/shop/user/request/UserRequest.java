package quick.pager.shop.user.request;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 用户请求
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
public class UserRequest implements Serializable {
    private static final long serialVersionUID = -8269998162761261662L;

    /**
     * 用户主键集
     */
    private List<Long> userIds;

    /**
     * 手机号码集
     */
    private List<String> phones;
}
