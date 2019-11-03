package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.mapper.BannerMapper;
import quick.pager.shop.model.activity.Banner;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.BannerService;

/**
 * Banner service impl
 *
 * @author siguiyang
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Override
    public Response<List<Banner>> list(BannerDTO dto) {

        Banner banner = new Banner();

        if (!StringUtils.isEmpty(dto.getTitle())) {
            banner.setTitle(dto.getTitle());
        }

        if (!StringUtils.isEmpty(dto.getBannerType())) {
            banner.setBannerType(dto.getBannerType());
        }

        QueryWrapper<Banner> qw = new QueryWrapper<>(banner);
        qw.orderByDesc("id");


        return this.toPage(dto.getPage(), dto.getPageSize(), qw);
    }

    @Override
    public Response<List<Banner>> getBanners(String bannerType) {
        QueryWrapper<Banner> qw = new QueryWrapper<>();
        qw.eq("delete_status", Boolean.FALSE);
        qw.eq("banner_type", bannerType);
        return Response.toResponse(this.baseMapper.selectList(qw), 0);
    }
}
