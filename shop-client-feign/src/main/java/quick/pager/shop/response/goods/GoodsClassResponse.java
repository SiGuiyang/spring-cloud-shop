package quick.pager.shop.response.goods;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.response.BasicResponse;
import quick.pager.shop.response.activity.BannerResponse;

/**
 * 商品分类响应对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsClassResponse extends BasicResponse {
    private static final long serialVersionUID = -3807725086026024155L;

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
    private List<GoodsClassResponse> children;
    /**
     * 关联的banner列表
     */
    private List<BannerResponse> banners;
}
