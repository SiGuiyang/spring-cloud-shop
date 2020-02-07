package quick.pager.shop.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class MenuDTO implements Serializable {
    private static final long serialVersionUID = 5088953188543039217L;

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

    private Boolean hidden;
}
