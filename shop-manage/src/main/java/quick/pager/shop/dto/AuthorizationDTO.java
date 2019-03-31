package quick.pager.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationDTO extends ManageDTO {

    private static final long serialVersionUID = 4399880937415097395L;

    private String permissions;
}
