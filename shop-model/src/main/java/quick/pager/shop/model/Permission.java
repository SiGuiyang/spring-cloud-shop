package quick.pager.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Permission extends Model {

    private static final long serialVersionUID = -6824447744737990261L;
    /**
     * 父级权限菜单Id
     */
    private Long parentId;

    private String permission;

    private String name;

    private String createUser;
    /**
     * 类型
     */
    private Integer permissionType;

    private String permissionTypeName;

    private String createTimeName;

    private List<Permission> children = new ArrayList<>();


}