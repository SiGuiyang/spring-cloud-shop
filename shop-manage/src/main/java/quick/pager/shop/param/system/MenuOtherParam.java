package quick.pager.shop.param.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.PageParam;

/**
 * 菜单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuOtherParam extends PageParam {
    private static final long serialVersionUID = -7242388842224416719L;

    private Integer menuType;

    private String name;
}
