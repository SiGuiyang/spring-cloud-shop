package quick.pager.shop.goods.request;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.Request;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassificationRequest extends Request {
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
    private List<ClassificationRequest> children = new ArrayList<>();
//    /**
//     * 关联的banner列表
//     */
//    private List<BannerDTO> bannerDTOS = new ArrayList<>();

}
