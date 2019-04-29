package quick.pager.shop.service.goods;

import quick.pager.shop.dto.ClassificationDTO;
import quick.pager.shop.response.Response;

/**
 * 商品分类服务
 *
 * @author siguiyang
 */
public interface ClassificationService {

    /**
     * 分类列表
     *
     * @param className 分类名称
     */
    Response classificationList(String className);

    /**
     * 修改商品分类
     */
    Response modifyClassification(ClassificationDTO dto);
}
