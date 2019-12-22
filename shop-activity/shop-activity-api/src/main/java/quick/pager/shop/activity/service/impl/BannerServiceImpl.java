package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.activity.mapper.BannerMapper;
import quick.pager.shop.activity.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.BannerService;

/**
 * Banner service impl
 *
 * @author siguiyang
 * @version 3.0
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Override
    public Response<List<Banner>> queryPage(BannerPageRequest request) {
        QueryWrapper<Banner> qw = toQuery(request.getTitle(), request.getBannerType());

        return this.toPage(request.getPage(), request.getPageSize(), qw);
    }

    @Override
    public List<Banner> queryList(BannerOtherRequest request) {
        QueryWrapper<Banner> qw = toQuery(request.getTitle(), request.getBannerType());

        return this.baseMapper.selectList(qw);
    }

    @Override
    public List<Banner> getBanners(String bannerType) {
        Banner banner = new Banner();
        banner.setDeleteStatus(Boolean.FALSE);
        banner.setBannerType(bannerType);
        return this.baseMapper.selectList(new QueryWrapper<>(banner));
    }

    private QueryWrapper<Banner> toQuery(String title, String bannerType) {
        Banner banner = new Banner();

        if (!StringUtils.isEmpty(title)) {
            banner.setTitle(title);
        }
        if (!StringUtils.isEmpty(bannerType)) {
            banner.setBannerType(bannerType);
        }

        QueryWrapper<Banner> qw = new QueryWrapper<>(banner);
        qw.orderByDesc("id");

        return qw;
    }
}
