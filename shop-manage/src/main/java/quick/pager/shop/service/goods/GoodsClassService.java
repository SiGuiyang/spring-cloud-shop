package quick.pager.shop.service.goods;

import quick.pager.shop.dto.goods.ClassificationDTO;
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
    Response list(ClassificationDTO dto);

    /**
     * 新增分类
     */
    Response create(ClassificationDTO dto);

    /**
     * 修改分类
     */
    Response modify(ClassificationDTO dto);

    /**
     * 分类树形结构
     */
    Response tree();
}
