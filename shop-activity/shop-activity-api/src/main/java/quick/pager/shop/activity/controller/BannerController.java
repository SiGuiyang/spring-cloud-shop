package quick.pager.shop.activity.controller;

import com.google.common.base.Joiner;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.BannerService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;
import quick.pager.shop.utils.DateUtils;

/**
 * banner管理
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * banner 列表
     */
    @PostMapping("/banner/queryList")
    public Response<List<BannerResponse>> queryList(@RequestBody BannerOtherRequest request) {
        List<Banner> list = bannerService.queryList(request);

        return Response.toResponse(Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                0);
    }

    /**
     * banner 列表
     */
    @PostMapping("/banner/queryPage")
    public Response<List<BannerResponse>> queryPage(@RequestBody BannerPageRequest request) {
        Response<List<Banner>> response = bannerService.queryPage(request);

        List<BannerResponse> list = Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                .map(this::convert)
                .collect(Collectors.toList());

        return Response.toResponse(list, response.getTotal());
    }

    /**
     * banner 新增
     */
    @PostMapping("/banner/create")
    public Response<Long> create(@RequestBody BannerSaveRequest request) {
        Banner banner = new Banner();
        BeanCopier.create(request, banner).copy();
        doChannel(banner, request.getShareChannel());
        banner.setBannerStatus(Boolean.FALSE);
        banner.setDeleteStatus(Boolean.FALSE);
        banner.setCreateTime(DateUtils.dateTime());
        bannerService.save(banner);
        return new Response<>(banner.getId());

    }

    /**
     * banner 修改
     */
    @PutMapping("/banner/modify")
    public Response<Long> modify(@RequestBody BannerSaveRequest request) {
        Banner banner = BeanCopier.create(request, new Banner()).copy();
        doChannel(banner, request.getShareChannel());
        bannerService.updateById(banner);
        return new Response<>(banner.getId());
    }

    /**
     * 根据banner类型查询列表
     */
    @PostMapping("/banner/listAll")
    public Response<List<BannerResponse>> listAll(@RequestBody BannerPageRequest request) {
        List<Banner> banners = bannerService.getBanners(request.getBannerType());
        List<BannerResponse> list = Optional.ofNullable(banners).orElse(Collections.emptyList()).stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return Response.toResponse(list, 0);
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
        }
        return response;
    }
}
