package quick.pager.shop.goods.response.classification;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 一级分类下的详情
 *
 * @author siguiyang
 */
@Data
public class AppGoodsClassificationResponse implements Serializable {
    private static final long serialVersionUID = 7718730100415756686L;

    /**
     * 该分类下的推荐Banner列表
     */
    private List<AppGoodsBannerResponse> goodsBanners;
    /**
     * 分类详情
     */
    private List<AppGoodsClassificationDetailResponse> details;

}
