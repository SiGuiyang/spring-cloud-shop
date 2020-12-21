package quick.pager.shop.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户实体
 *
 * @author siguiyang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -55245934987340282L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 昵称
     */
    private String username;
    /**
     * 权限
     */
    private List<String> authorities;
    /**
     * 登录token
     */
    private String token;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 性别
     */
    private Boolean gender;
}
