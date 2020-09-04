package quick.pager.shop.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * 用户基本信息
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfo extends Model {

    private static final long serialVersionUID = 788660856242390694L;

    /**
     * 用户主键
     */
    private Long userId;
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
