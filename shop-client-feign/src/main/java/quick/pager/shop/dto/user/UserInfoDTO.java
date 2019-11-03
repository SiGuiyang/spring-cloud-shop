package quick.pager.shop.dto.user;


import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.BaseDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoDTO extends BaseDTO {
    private static final long serialVersionUID = -2189550686183346833L;

    /**
     * 手机号
     */
    private String phone;

    private String password;

    private Byte serverStatus;

    private String username;

    private Boolean gender;

    private Byte age;

    private String email;

    private Date birthday;

    private String avatar;
}
