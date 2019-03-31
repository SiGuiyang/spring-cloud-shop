package quick.pager.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRole extends Model {

    private static final long serialVersionUID = 8913616211754943405L;

    private Long roleId;

    private Long sysUserId;


}