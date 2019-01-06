package quick.pager.shop.model.manage;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.model.Model;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRole extends Model {

    private static final long serialVersionUID = 8913616211754943405L;

    private Long roleId;

    private Long sysUserId;


}