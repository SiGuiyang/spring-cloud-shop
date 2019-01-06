package quick.pager.shop.manage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginDTO extends DTO {
    private static final long serialVersionUID = 6921770318112785417L;

    private String username;

    private String password;
}
