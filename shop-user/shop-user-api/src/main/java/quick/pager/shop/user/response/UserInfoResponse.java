package quick.pager.shop.user.response;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    private Integer age;

    private String email;

    private Date birthday;

    private String avatar;
}
