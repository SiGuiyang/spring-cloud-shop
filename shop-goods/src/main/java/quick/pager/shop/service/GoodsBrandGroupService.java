package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;

/**
 * <p>
 * 品牌组 服务类
 * </p>
 *
 * @author Siguiyang
 * @since 2019-10-07
 */
public interface GoodsBrandGroupService extends IPageService<GoodsBrandGroup> {

    /**
     * 商品品牌组列表
     */
    Response<List<GoodsBrandGroup>> groupList(GoodsBrandGroupDTO dto);
}
