package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商户
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Seller extends Model {

    private static final long serialVersionUID = 8487325370020125166L;
    /**
     * 登陆用户名
     */
    private String username;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
}
