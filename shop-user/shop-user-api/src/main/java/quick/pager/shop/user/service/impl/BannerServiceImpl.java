package quick.pager.shop.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.user.service.BannerService;

/**
 * BannerServiceImpl
 *
 * @author siguiyang
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerClient bannerClient;

    @Override
    public Response<List<BannerResponse>> queryList() {

        BannerOtherRequest bannerOtherRequest = new BannerOtherRequest();
        bannerOtherRequest.setBannerStatus(Boolean.FALSE);
        return bannerClient.queryList(bannerOtherRequest);
    }
}
