package quick.pager.shop.param.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

/**
 * 菜单
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuSaveParam extends Param {

    private static final long serialVersionUID = 2086881622142051682L;

    private Long id;

    private Long parentId;

    private Integer sequence;

    private Integer menuType;

    private String name;

    private String path;

    private String component;

    private String redirect;

    private String icon;

    private String permission;

    private String permissionName;

    private Boolean router;

    private Boolean hidden;
}
