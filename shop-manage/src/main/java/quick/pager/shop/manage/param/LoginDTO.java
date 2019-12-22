package quick.pager.shop.manage.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.BaseDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginDTO extends BaseDTO {
    private static final long serialVersionUID = 6921770318112785417L;

    private String username;

    private String password;
}
