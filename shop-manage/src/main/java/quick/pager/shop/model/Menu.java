package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import quick.pager.shop.model.Model;

/**
 * 菜单资源
 *
 * @author siguiyang
 */
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

    private String path;

    private String component;

    private String redirect;

    private String icon;

    private String permission;

    private Boolean router;

    private Boolean hidden;

}
