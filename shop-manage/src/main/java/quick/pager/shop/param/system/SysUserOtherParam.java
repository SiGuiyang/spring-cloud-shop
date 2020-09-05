package quick.pager.shop.param.system;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserOtherParam extends Param {

    private static final long serialVersionUID = 4605018155519897838L;

    /**
     * 用户主键集
     */
    private List<Long> ids;

    private String phone;

    private String username;

    private List<Long> roleIds;

}
