package quick.pager.shop.service.activity.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.client.activity.BannerClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.model.activity.Banner;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.activity.BannerResponse;
import quick.pager.shop.service.activity.BannerService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerClient bannerClient;

    @Override
    public Response<List<BannerResponse>> fetch(BannerDTO dto) {
        Response<List<Banner>> response = bannerClient.fetch(dto);

        if (ResponseStatus.Code.SUCCESS != response.getCode()) {
            return new Response<>(response.getCode(), response.getMsg());
        }
        List<Banner> data = response.getData();
        List<BannerResponse> collect = Optional.ofNullable(data).orElse(Collections.emptyList())
                .stream().map(this::convert).collect(Collectors.toList());
        return Response.toResponse(collect, response.getTotal());
    }

    @Override
    public Response create(BannerDTO dto) {
        return bannerClient.create(dto);
    }

    @Override
    public Response modify(BannerDTO dto) {
        return bannerClient.modify(dto);
    }

    @Override
    public Response listAll(BannerDTO dto) {
        return bannerClient.listAll(dto);
    }

    /**
     * 数据转换
     */
    private BannerResponse convert(Banner banner) {
        BannerResponse bannerResponse = BeanCopier.create(banner, new BannerResponse(), CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true))
                .copy();
        if (!StringUtils.isEmpty(banner.getShareChannel())) {
            bannerResponse.setShareChannel(Stream.of((String[]) ConvertUtils.convert(banner.getShareChannel().split(Constants.COMMA), String.class)).collect(Collectors.toList()));
        }
        return bannerResponse;
    }
}
