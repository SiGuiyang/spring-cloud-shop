package quick.pager.shop.activity.controller;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.BannerService;
import quick.pager.shop.utils.BeanCopier;

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
    @PostMapping("/banner/list")
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
    @PostMapping("/banner/page")
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
        return bannerService.create(request);

    }

    /**
     * banner 修改
     */
    @PutMapping("/banner/modify")
    public Response<Long> modify(@RequestBody BannerSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return bannerService.modify(request);
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
