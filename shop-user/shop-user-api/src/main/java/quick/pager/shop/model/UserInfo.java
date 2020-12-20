package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;

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
@TableName("t_user_info")
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
     * 生日
     */
    private LocalDate birthday;
    /**
     * 头像地址
     */
    private String avatar;

}
