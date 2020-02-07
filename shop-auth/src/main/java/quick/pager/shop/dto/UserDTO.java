package quick.pager.shop.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 3462481232090532831L;
    private Long id;

    /**
     * 登陆用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
