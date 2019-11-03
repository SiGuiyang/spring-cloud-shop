package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManageDTO extends BaseDTO {
    private static final long serialVersionUID = -198889296092773549L;

    /**
     * 系统登陆名
     */
    private String username;

    /**
     * 操作人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;

}
