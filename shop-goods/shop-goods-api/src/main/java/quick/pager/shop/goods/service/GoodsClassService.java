package quick.pager.shop.goods.service;

import java.util.List;
import quick.pager.shop.goods.model.GoodsClass;
import quick.pager.shop.goods.response.classification.GoodsClassificationResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsClassService extends IPageService<GoodsClass> {

    /**
     * 获取分类列表
     *
     * @param className 分类名称
     * @param page      页码
     * @param pageSize  一页显示的大小
     */
    Response<List<GoodsClassificationResponse>> getGoodsClass(String className, Integer page, Integer pageSize);

    /**
     * 商品树形结构
     */
    Response<List<GoodsClassificationResponse>> classificationTree();
}
