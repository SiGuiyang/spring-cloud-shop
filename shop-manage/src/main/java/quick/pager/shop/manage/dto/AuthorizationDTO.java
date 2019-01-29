package quick.pager.shop.manage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationDTO extends ManageDTO {

    private static final long serialVersionUID = 4399880937415097395L;

    private String permissions;
}
