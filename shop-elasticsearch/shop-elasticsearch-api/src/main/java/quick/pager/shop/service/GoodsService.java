package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.elasticsearch.request.ESGoodsPageRequest;
import quick.pager.shop.elasticsearch.response.ESGoodsResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品ES服务
 *
 * @author siguiyang
 */
public interface GoodsService {

    /**
     * 查询商品
     *
     * @param request 请求参数
     */
    Response<List<ESGoodsResponse>> queryPage(final ESGoodsPageRequest request);
}
