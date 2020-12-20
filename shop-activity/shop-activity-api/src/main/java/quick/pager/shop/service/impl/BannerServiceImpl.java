package quick.pager.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.constants.ActivityRedisKeys;
import quick.pager.shop.mapper.BannerMapper;
import quick.pager.shop.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerChannelResponse;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.SConsts;
import quick.pager.shop.platform.client.SystemConfigDetailClient;
import quick.pager.shop.platform.dto.SystemConfigDTO;
import quick.pager.shop.platform.request.SystemConfigDetailOtherRequest;
import quick.pager.shop.platform.response.SystemConfigDetailResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.BannerService;
import quick.pager.shop.utils.Assert;
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
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private SystemConfigDetailClient systemConfigDetailClient;

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

    @Override
    public Response<Long> create(BannerSaveRequest request) {
        Banner banner = new Banner();
        BeanCopier.create(request, banner).copy();
        doChannel(banner, request.getShareChannel());
        banner.setBannerStatus(Boolean.FALSE);
        banner.setDeleteStatus(Boolean.FALSE);
        banner.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(banner);
        return Response.toResponse(banner.getId());
    }

    @Override
    public Response<Long> modify(BannerSaveRequest request) {
        Banner banner = BeanCopier.create(request, new Banner()).copy();
        doChannel(banner, request.getShareChannel());
        this.baseMapper.updateById(banner);
        return Response.toResponse(banner.getId());
    }

    @Override
    public Response<List<BannerResponse>> banners(Long userId, String lat, String lng) {

        Long size = redisTemplate.opsForList().size(ActivityRedisKeys.APP_BANNER_PREFIX);
        if (Objects.nonNull(size)) {
            // 缓存存在则直接返回
            List<Object> result = redisTemplate.opsForList().range(ActivityRedisKeys.APP_BANNER_PREFIX, 0, size);

            if (CollectionUtils.isNotEmpty(result)) {
                return Response.toResponse(JSON.parseArray(JSON.toJSONString(result), BannerResponse.class));
            }
        }

        List<Banner> banners = this.baseMapper.selectList(new LambdaQueryWrapper<Banner>()
                .eq(Banner::getDeleteStatus, Boolean.FALSE)
                .eq(Banner::getBannerStatus, Boolean.FALSE));

        List<BannerResponse> result = banners.stream().map(this::convert).collect(Collectors.toList());

        return Response.toResponse(result);
    }

    @Override
    public Response<List<BannerChannelResponse>> channel(Long id) {

        Banner banner = this.baseMapper.selectById(id);

        Assert.isTrue(Objects.nonNull(banner), () -> "banner 不存在！");

        Assert.isTrue(StringUtils.isNotEmpty(banner.getShareChannel()), () -> "渠道不存在！");

        List<String> shareChannels = Stream.of(banner.getShareChannel().split(SConsts.EN_COMMA)).collect(Collectors.toList());
        Long size = redisTemplate.opsForList().size(ActivityRedisKeys.BANNER_SHARE_CHANNEL);

        List<SystemConfigDTO> configDTOS = null;
        if (Objects.isNull(size)) {
            SystemConfigDetailOtherRequest systemConfigDetailOtherReq = new SystemConfigDetailOtherRequest();
            systemConfigDetailOtherReq.setConfigKey(ActivityRedisKeys.BANNER_SHARE_CHANNEL);
            Response<List<SystemConfigDetailResponse>> systemConfigDetailOtherRes = systemConfigDetailClient.queryList(systemConfigDetailOtherReq);
            if (systemConfigDetailOtherRes.check()) {
                configDTOS = systemConfigDetailOtherRes.getData().stream().map(item -> {
                    SystemConfigDTO dto = new SystemConfigDTO();
                    dto.setConfigType(item.getConfigType());
                    dto.setConfigValue(item.getConfigValue());
                    dto.setConfigName(item.getConfigName());
                    return dto;
                }).collect(Collectors.toList());
            }
        } else {
            List<Object> result = redisTemplate.opsForList().range(ActivityRedisKeys.BANNER_SHARE_CHANNEL, 0, size);
            configDTOS = JSON.parseArray(JSON.toJSONString(result), SystemConfigDTO.class);
        }

        return Response.toResponse(Optional.ofNullable(configDTOS).orElse(Lists.newArrayList()).stream()
                .filter(item -> shareChannels.contains(item.getConfigValue()))
                .map(item -> {
                    BannerChannelResponse response = new BannerChannelResponse();
                    response.setChannelName(item.getConfigName());
                    response.setChannelType(item.getConfigValue());
                    return response;
                })
                .collect(Collectors.toList()));
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
        // 添加缓存
        redisTemplate.opsForList().leftPush(ActivityRedisKeys.APP_BANNER_PREFIX, response);
        return response;
    }

    private LambdaQueryWrapper<Banner> toQuery(String title, String bannerType, Boolean bannerStatus) {
        return new LambdaQueryWrapper<Banner>()
                .likeRight(StringUtils.isNotEmpty(title), Banner::getTitle, title)
                .eq(StringUtils.isNotEmpty(bannerType), Banner::getBannerType, bannerType)
                .eq(Objects.nonNull(bannerStatus), Banner::getBannerStatus, bannerStatus)
                .orderByDesc(Banner::getUpdateTime);
    }
}
