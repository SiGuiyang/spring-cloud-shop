package quick.pager.shop.goods.response.classification;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;

/**
 * 商品分类响应对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsClassificationResponse extends BasicResponse {
    private static final long serialVersionUID = -3807725086026024155L;

    private Long id;
    /**
     * 商品父级Id
     */
    private Long parentId;
    /**
     * banner 主键
     */
    private Long bannerId;
    /**
     * banner名称
     */
    private String bannerName;
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
    private List<GoodsClassificationResponse> children;
}
