package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Joiner;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.activity.mapper.BannerMapper;
import quick.pager.shop.activity.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.BannerService;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

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
        QueryWrapper<Banner> qw = toQuery(request.getTitle(), request.getBannerType(), null);

        return this.toPage(request.getPage(), request.getPageSize(), qw);
    }

    @Override
    public List<Banner> queryList(BannerOtherRequest request) {
        QueryWrapper<Banner> qw = toQuery(request.getTitle(), request.getBannerType(), request.getBannerStatus());

        return this.baseMapper.selectList(qw);
    }

    private QueryWrapper<Banner> toQuery(String title, String bannerType, Boolean bannerStatus) {
        Banner banner = new Banner();

        if (!StringUtils.isEmpty(title)) {
            banner.setTitle(title);
        }
        if (!StringUtils.isEmpty(bannerType)) {
            banner.setBannerType(bannerType);
        }

        if (Objects.nonNull(bannerStatus)) {
            banner.setBannerStatus(bannerStatus);
        }

        QueryWrapper<Banner> qw = new QueryWrapper<>(banner);
        qw.orderByDesc("id");

        return qw;
    }

    @Override
    public Response<Long> create(BannerSaveRequest request) {
        Banner banner = new Banner();
        BeanCopier.create(request, banner).copy();
        doChannel(banner, request.getShareChannel());
        banner.setBannerStatus(Boolean.FALSE);
        banner.setDeleteStatus(Boolean.FALSE);
        banner.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(banner);
        return new Response<>(banner.getId());
    }

    @Override
    public Response<Long> modify(BannerSaveRequest request) {
        Banner banner = BeanCopier.create(request, new Banner()).copy();
        doChannel(banner, request.getShareChannel());
        this.baseMapper.updateById(banner);
        return new Response<>(banner.getId());
    }


    private void doChannel(Banner banner, List<String> shareChannel) {
        if (CollectionUtils.isEmpty(shareChannel)) {
            banner.setShareChannel(null);
        } else {
            banner.setShareChannel(Joiner.on(Constants.COMMA).join(shareChannel));
        }
    }
}
