package quick.pager.shop.manage.service.goods.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.goods.client.GoodsBrandGroupClient;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupPageRequest;
import quick.pager.shop.goods.request.brand.GoodsBrandGroupSaveRequest;
import quick.pager.shop.goods.response.brand.GoodsBrandGroupResponse;
import quick.pager.shop.manage.param.goods.GoodsBrandGroupPageParam;
import quick.pager.shop.manage.param.goods.GoodsBrandGroupSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.goods.GoodsBrandGroupService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;

@Service
public class GoodsBrandGroupServiceImpl implements GoodsBrandGroupService {

    @Autowired
    private GoodsBrandGroupClient goodsBrandGroupClient;

    @Override
    public Response<List<GoodsBrandGroupResponse>> list(GoodsBrandGroupPageParam param) {
        GoodsBrandGroupPageRequest request = new GoodsBrandGroupPageRequest();
        BeanCopier.create(param, request).copy();

        return goodsBrandGroupClient.list(request);
    }

    @Override
    public Response create(GoodsBrandGroupSaveParam param) {
        GoodsBrandGroupSaveRequest request = new GoodsBrandGroupSaveRequest();
        BeanCopier.create(param, request).copy();

        return goodsBrandGroupClient.create(request);
    }

    @Override
    public Response modify(GoodsBrandGroupSaveParam param) {
        GoodsBrandGroupSaveRequest request = new GoodsBrandGroupSaveRequest();
        BeanCopier.create(param, request).copy();

        return goodsBrandGroupClient.modify(request);
    }

    @Override
    public Response<List<GoodsBrandGroupResponse>> listAll() {
        return goodsBrandGroupClient.listAll();
    }
}
