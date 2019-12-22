package quick.pager.shop.manage.service.goods;

import java.util.List;
import quick.pager.shop.goods.request.ClassificationRequest;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.manage.param.goods.ClassificationPageParam;
import quick.pager.shop.manage.param.goods.ClassificationSaveParam;
import quick.pager.shop.response.Response;

/**
 * 商品分类服务
 *
 * @author siguiyang
 */
public interface GoodsClassService {

    /**
     * 分类列表
     */
    Response<List<GoodsClassificationResponse>> list(ClassificationPageParam dto);

    /**
     * 新增分类
     */
    Response<Long> create(ClassificationSaveParam dto);

    /**
     * 修改分类
     */
    Response<Long> modify(ClassificationSaveParam dto);

    /**
     * 分类树形结构
     */
    Response tree();
}
