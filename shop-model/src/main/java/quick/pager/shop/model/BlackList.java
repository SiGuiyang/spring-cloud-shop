package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author siguiyang
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class BlackList extends Model {
    private static final long serialVersionUID = 71428320572149224L;
    /**
     * 手机号
     */
    private String phone;
    private String createUser;
}
