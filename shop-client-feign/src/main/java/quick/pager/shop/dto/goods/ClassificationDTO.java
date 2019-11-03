package quick.pager.shop.dto.goods;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.dto.ManageDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationDTO extends ManageDTO {
    private static final long serialVersionUID = 8834227650288882046L;

    /**
     * 商品父级Id
     */
    private Long parentId;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 父级菜单名称
     */
    private String parentClassName;

    /**
     * 分类图标
     */
    private String icon;
    /**
     * 子集分类
     */
    private List<ClassificationDTO> children = new ArrayList<>();
    /**
     * 关联的banner列表
     */
    private List<BannerDTO> bannerDTOS = new ArrayList<>();

}
