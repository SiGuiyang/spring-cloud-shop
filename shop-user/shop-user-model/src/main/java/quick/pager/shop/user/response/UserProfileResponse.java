package quick.pager.shop.user.response;


import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserProfileResponse extends BasicResponse {
    private static final long serialVersionUID = -2189550686183346833L;

    private Long id;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 昵称
     */
    private String username;
    /**
     * 性别
     * true 男，false 女
     */
    private Boolean gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 生日
     */
    private LocalDateTime birthday;
    /**
     * 头像地址
     */
    private String avatar;
}
