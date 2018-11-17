package quick.pager.shop.activity.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.activity.mapper.BannerMapper;
import quick.pager.shop.model.activity.Banner;

@Service
@Slf4j
public class BannerService implements IService<List<Banner>> {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public Response<List<Banner>> doService(DTO dto) {

        List<Banner> banners = bannerMapper.selectAll();
        return new Response<>(banners);
    }
}
