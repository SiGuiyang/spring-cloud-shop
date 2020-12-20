package quick.pager.shop.response.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 * 菜单响应对象
 *
 * @author siguiyang
 */
@Data
public class MenuResponse implements Serializable {
    private static final long serialVersionUID = -6427332873494498814L;

    private Long id;

    private Long parentId;

    private Integer sequence;

    private Integer menuType;

    private String name;

    private String label;

    private String path;

    private String component;

    private String redirect;

    private String icon;

    private String permission;

    private Boolean hidden;

    private Boolean router;

    private String updateUser;

    private LocalDateTime updateTime;

    private List<MenuResponse> children;

    private MenuResponse.Meta meta;

    @Data
    public static class Meta implements Serializable {

        private static final long serialVersionUID = -3075193428932941702L;

        private String title;

        private String icon;

        private boolean noCache;

        private List<String> permission;

        public Meta(String title, String icon, boolean noCache, List<String> permission) {
            this.title = title;
            this.icon = icon;
            this.noCache = noCache;
            this.permission = permission;
        }
    }
}
