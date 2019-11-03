package quick.pager.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import quick.pager.shop.dto.goods.ClassificationDTO;
import quick.pager.shop.model.goods.GoodsClass;
import quick.pager.shop.response.Response;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsClassService extends IService<GoodsClass> {

    /**
     * 获取分类列表
     *
     * @param className 分类名称
     * @param page      页码
     * @param pageSize  一页显示的大小
     */
    Response<List<ClassificationDTO>> getGoodsClass(String className, Integer page, Integer pageSize);

    /**
     * 商品树形结构
     */
    Response<List<ClassificationDTO>> classificationTree();
}
