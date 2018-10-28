package quick.pager.shop.model.user;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

/**
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfo extends Model {

    private Long userId;

    private String username;

    private Boolean gender;

    private Byte age;

    private String email;

    private Date birthday;

    private String avatar;

}