package quick.pager.shop.model.feign.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoDTO extends DTO {
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