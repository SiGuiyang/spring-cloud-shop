package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseUser extends Model {
    private static final long serialVersionUID = -7522527085222814975L;
    // 登陆用户名
    private String username;
    // 手机号码
    private String phone;
    // 密码
    private String password;

}
