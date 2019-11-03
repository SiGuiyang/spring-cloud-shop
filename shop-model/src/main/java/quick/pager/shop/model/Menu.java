package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("t_menu")
public class Menu extends Model {

    private static final long serialVersionUID = -3246720425417855255L;

    private Long parentId;

    private Integer sequence;

    private Integer menuType;

    private String name;

    private String text;

    private String path;

    private String component;

    private String redirect;

    private String icon;

    private String permission;

    private String permissionName;

    private Boolean hidden;
    @TableField(exist = false)
    private List<Menu> children = new ArrayList<>();
    @TableField(exist = false)
    private Meta meta;

    @Data
    public static class Meta implements Serializable {

        private static final long serialVersionUID = -3075193428932941702L;

        private String title;

        private String icon;

        private boolean noCache;

        private Set<String> permission;

        public Meta(String title, String icon, boolean noCache, Set<String> permission) {
            this.title = title;
            this.icon = icon;
            this.noCache = noCache;
            this.permission = permission;
        }


    }

}
