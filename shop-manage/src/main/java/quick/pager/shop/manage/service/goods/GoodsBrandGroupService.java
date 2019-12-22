package quick.pager.shop.manage.service.goods;

import java.util.List;
import quick.pager.shop.goods.response.brand.GoodsBrandGroupResponse;
import quick.pager.shop.manage.param.goods.GoodsBrandGroupPageParam;
import quick.pager.shop.manage.param.goods.GoodsBrandGroupSaveParam;
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
    Response<List<GoodsBrandGroupResponse>> list(GoodsBrandGroupPageParam request);

    /**
     * 创建品牌组
     */
    Response create(GoodsBrandGroupSaveParam param);

    /**
     * 修改品牌组
     */
    Response modify(GoodsBrandGroupSaveParam param);

    /**
     * 查询所有品牌组
     */
    Response<List<GoodsBrandGroupResponse>> listAll();
}
