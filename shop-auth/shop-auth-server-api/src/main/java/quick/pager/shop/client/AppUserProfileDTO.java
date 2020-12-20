package quick.pager.shop.client;


import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author siguiyang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserProfileDTO implements Serializable {
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
     * 生日
     */
    private LocalDate birthday;
    /**
     * 头像地址
     */
    private String avatar;
}
