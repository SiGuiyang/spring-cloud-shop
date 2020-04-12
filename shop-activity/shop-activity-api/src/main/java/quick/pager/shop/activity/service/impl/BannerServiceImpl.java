package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.activity.mapper.BannerMapper;
import quick.pager.shop.activity.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.BannerService;
import quick.pager.shop.service.RedisService;
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

    @Autowired
    private RedisService redisService;

    @Override
    public Response<List<BannerResponse>> queryPage(BannerPageRequest request) {
        LambdaQueryWrapper<Banner> qw = toQuery(request.getTitle(), request.getBannerType(), null);
        Response<List<Banner>> page = this.toPage(request.getPage(), request.getPageSize(), qw);
        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<List<BannerResponse>> queryList(BannerOtherRequest request) {
        LambdaQueryWrapper<Banner> qw = toQuery(request.getTitle(), request.getBannerType(), request.getBannerStatus());

        List<Banner> banners = this.baseMapper.selectList(qw);
        return Response.toResponse(banners.stream().map(this::convert).collect(Collectors.toList()), 0L);
    }

    private LambdaQueryWrapper<Banner> toQuery(String title, String bannerType, Boolean bannerStatus) {
        LambdaQueryWrapper<Banner> wrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotEmpty(title)) {
            wrapper.likeRight(Banner::getTitle, title);
        }
        if (!StringUtils.isEmpty(bannerType)) {
            wrapper.eq(Banner::getBannerType, bannerType);
        }

        if (Objects.nonNull(bannerStatus)) {
            wrapper.eq(Banner::getBannerStatus, bannerStatus);
        }

        wrapper.orderByDesc(Banner::getUpdateTime);

        return wrapper;
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

    /**
     * Banner -> BannerResponse
     */
    private BannerResponse convert(Banner banner) {
        BannerResponse response = new BannerResponse();
        BeanCopier.create(banner, response).copy();
        if (StringUtils.isNotBlank(banner.getShareChannel())) {
            response.setShareChannel(
                    Stream.of((String[]) ConvertUtils.convert(banner.getShareChannel().split(Constants.COMMA), String.class))
                            .collect(Collectors.toList()));
        } else {
            response.setShareChannel(Lists.newArrayList());
        }
        return response;
    }
}
