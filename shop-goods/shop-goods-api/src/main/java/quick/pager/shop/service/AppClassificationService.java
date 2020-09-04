package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.goods.response.classification.AppGoodsClassificationResponse;
import quick.pager.shop.user.response.CommonResponse;
import quick.pager.shop.user.response.Response;

/**
 * APP 商品分类
 *
 * @author siguiyang
 */
public interface AppClassificationService {

    /**
     * 分类列表
     */
    Response<List<CommonResponse>> classifications();

    /**
     * 分类对应的详情
     * 包含左侧分类对应的推荐信息
     * 以及二级分类对应的详情
     *
     * @param classificationId 分类主键
     */
    Response<AppGoodsClassificationResponse> detail(final Long classificationId);

}
