package quick.pager.shop.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

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