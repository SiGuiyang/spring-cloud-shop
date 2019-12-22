package quick.pager.shop.manage.service.activity.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.manage.param.banner.BannerPageParam;
import quick.pager.shop.manage.param.banner.BannerSaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.BannerService;
import quick.pager.shop.utils.BeanCopier;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerClient bannerClient;

    @Override
    public Response<List<BannerResponse>> queryPage(BannerPageParam param) {
        BannerPageRequest request = new BannerPageRequest();
        BeanCopier.create(param, request).copy();
        return bannerClient.queryPage(request);
    }

    @Override
    public Response<Long> create(BannerSaveParam param) {

        BannerSaveRequest request = new BannerSaveRequest();
        BeanCopier.create(param, request).copy();
        return bannerClient.create(request);
    }

    @Override
    public Response<Long> modify(BannerSaveParam param) {
        BannerSaveRequest request = new BannerSaveRequest();
        BeanCopier.create(param, request).copy();
        return bannerClient.modify(request);
    }

    @Override
    public Response listAll(BannerPageParam dto) {
//        return bannerClient.listAll(dto);
        return null;
    }

}
