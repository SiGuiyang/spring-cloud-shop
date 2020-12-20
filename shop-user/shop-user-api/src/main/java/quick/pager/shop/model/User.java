package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * app 用户
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_user")
public class User extends Model {

    private static final long serialVersionUID = 6874571522967825468L;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 登陆密码
     */
    private String password;

}
