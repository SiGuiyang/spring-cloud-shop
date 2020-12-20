package quick.pager.shop.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.elasticsearch.client.ESGoodsClient;
import quick.pager.shop.elasticsearch.request.ESGoodsPageRequest;
import quick.pager.shop.elasticsearch.response.ESGoodsResponse;
import quick.pager.shop.param.GoodsSearchParam;
import quick.pager.shop.goods.response.GoodsResponse;
import quick.pager.shop.service.AppGoodsSkuService;
import quick.pager.shop.user.response.Response;

/**
 * @author siguiyang
 */
@Service
public class AppGoodsSkuServiceImpl implements AppGoodsSkuService {

    @Autowired
    private ESGoodsClient esGoodsClient;

    @Override
    public Response<List<GoodsResponse>> querySku(final GoodsSearchParam param) {
        ESGoodsPageRequest request = new ESGoodsPageRequest();
        request.setGoodsClassId(param.getGoodsClassId());
        request.setGoodsName(param.getGoodsName());
        request.setKeyword(param.getKeyword());
        request.setSort(param.getSort());

        Response<List<ESGoodsResponse>> pageRes = this.esGoodsClient.queryPage(request);
        if (!pageRes.check()) {
            return Response.toError(pageRes.getCode(), pageRes.getMsg());
        }
        return Response.toResponse(pageRes.getData().stream().map(this::conv).collect(Collectors.toList()), pageRes.getTotal());
    }

    /**
     * 商品转换
     */
    private GoodsResponse conv(final ESGoodsResponse goods) {
        return new GoodsResponse();
    }
}
