package quick.pager.shop.manage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginDTO extends ManageDTO {
    private static final long serialVersionUID = 6921770318112785417L;

    private String username;

    private String password;
}
