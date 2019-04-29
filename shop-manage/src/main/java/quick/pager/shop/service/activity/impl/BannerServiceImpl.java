package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.BannerService;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private ActivityClient activityClient;

    @Override
    public Response fetch(BannerDTO dto) {
        return activityClient.fetch(dto);
    }

    @Override
    public Response addBanner(BannerDTO dto) {
        return activityClient.addBanner(dto);
    }

    @Override
    public Response modifyBanner(BannerDTO dto) {
        return activityClient.modifyBanner(dto);
    }
}
