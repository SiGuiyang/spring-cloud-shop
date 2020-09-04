package quick.pager.shop.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserInfoResponse implements Serializable {
    private static final long serialVersionUID = -4170663634334464488L;

    private Long userId;
    /**
     * 手机号
     */
    private String phone;

    private String password;

    private String username;

    private Boolean gender;

    private Byte age;

    private String email;

    private Date birthday;

    private String avatar;
}
