package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.goods.GoodsBrandGroupDTO;
import quick.pager.shop.model.goods.GoodsBrandGroup;
import quick.pager.shop.response.Response;

/**
 * 商品品牌组服务
 *
 * @author siguiyang
 */
public interface GoodsBrandGroupService {

    /**
     * 品牌组列表
     */
    Response<List<GoodsBrandGroup>> list(GoodsBrandGroupDTO dto);

    /**
     * 创建品牌组
     */
    Response create(GoodsBrandGroupDTO dto);

    /**
     * 修改品牌组
     */
    Response modify(GoodsBrandGroupDTO dto);

    /**
     * 查询所有品牌组
     */
    Response<List<GoodsBrandGroup>> listAll();
}
