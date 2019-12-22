package quick.pager.shop.manage.service.goods.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.client.GoodsBrandClient;
import quick.pager.shop.goods.request.brand.GoodsBrandPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandResponse;
import quick.pager.shop.manage.param.goods.GoodsBrandPageParam;
import quick.pager.shop.manage.param.goods.GoodsBrandSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsBrandService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class GoodsBrandServiceImpl implements GoodsBrandService {

    @Autowired
    private GoodsBrandClient goodsBrandClient;

    @Override
    public Response<List<GoodsBrandResponse>> list(GoodsBrandPageParam param) {
        GoodsBrandPageRequest request = new GoodsBrandPageRequest();
        BeanCopier.create(param, request).copy();
        return goodsBrandClient.list(request);
    }

    @Override
    public Response create(GoodsBrandSaveParam param) {
        GoodsBrandSaveRequest request = new GoodsBrandSaveRequest();
        BeanCopier.create(param, request).copy();
        return goodsBrandClient.create(request);
    }

    @Override
    public Response modify(GoodsBrandSaveParam param) {
        GoodsBrandSaveRequest request = new GoodsBrandSaveRequest();
        BeanCopier.create(param, request).copy();
        return goodsBrandClient.modify(request);
    }
}
