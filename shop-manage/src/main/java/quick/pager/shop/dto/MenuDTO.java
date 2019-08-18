package quick.pager.shop.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuDTO extends ManageDTO {

    private static final long serialVersionUID = 2086881622142051682L;

    private Long parentId;
    @NotBlank(message = "序号不能为空")
    private Integer sequence;
    private Integer menuType;
    @NotBlank(message = "菜单名称不能为空")
    private String name;
    @NotBlank(message = "菜单路径不能为空")
    private String path;

    private String component;

    private String redirect;

    private String icon;

    private String permission;

    private String permissionName;

    private Boolean hidden;
}
