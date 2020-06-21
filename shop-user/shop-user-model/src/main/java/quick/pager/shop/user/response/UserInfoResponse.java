package quick.pager.shop.user.response;


import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoResponse extends BasicResponse {
    private static final long serialVersionUID = -2189550686183346833L;

    private Long id;
    /**
     * 手机号
     */
    private String phone;

    private String password;

    private Integer serverStatus;

    private String username;

    private Boolean gender;

    private Integer age;

    private String email;

    private Date birthday;

    private String avatar;
}
