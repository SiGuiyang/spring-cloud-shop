package quick.pager.shop.manage.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.common.dto.DTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationDTO extends DTO{

    private static final long serialVersionUID = 4399880937415097395L;

    private String permissions;
}
