package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.GoodsClassBannerMapper;
import quick.pager.shop.mapper.GoodsClassMapper;
import quick.pager.shop.mapper.GoodsSpuMapper;
import quick.pager.shop.model.GoodsClass;
import quick.pager.shop.model.GoodsClassBanner;
import quick.pager.shop.model.GoodsSpu;
import quick.pager.shop.goods.response.classification.AppGoodsBannerResponse;
import quick.pager.shop.goods.response.classification.AppGoodsClassificationDetailResponse;
import quick.pager.shop.goods.response.classification.AppGoodsClassificationResponse;
import quick.pager.shop.service.AppClassificationService;
import quick.pager.shop.user.response.CommonResponse;
import quick.pager.shop.user.response.Response;

@Service
public class AppClassificationServiceImpl implements AppClassificationService {

    @Autowired
    private GoodsClassMapper goodsClassMapper;
    @Autowired
    private GoodsClassBannerMapper goodsClassBannerMapper;
    @Autowired
    private GoodsSpuMapper goodsSpuMapper;
    @Autowired
    private BannerClient bannerClient;

    @Override
    public Response<List<CommonResponse>> classifications() {

        List<GoodsClass> goodsClasses = goodsClassMapper.selectList(new LambdaQueryWrapper<GoodsClass>()
                .eq(GoodsClass::getDeleteStatus, Boolean.FALSE)
                .isNull(GoodsClass::getParentId));

        return Response.toResponse(goodsClasses.stream().map(item -> {
            CommonResponse response = new CommonResponse();
            response.setId(item.getId());
            response.setName(item.getClassName());
            response.setIcon(item.getIcon());
            return response;
        }).collect(Collectors.toList()));
    }

    @Override
    public Response<AppGoodsClassificationResponse> detail(Long classificationId) {

        AppGoodsClassificationResponse response = new AppGoodsClassificationResponse();
        // 1. 查询分类推荐的banner
        List<GoodsClassBanner> goodsClassBanners = goodsClassBannerMapper.selectList(new LambdaQueryWrapper<GoodsClassBanner>()
                .eq(GoodsClassBanner::getDeleteStatus, Boolean.FALSE)
                .eq(GoodsClassBanner::getClassificationId, classificationId));
        response.setGoodsBanners(goodsClassBanners.stream().map(item -> {
            AppGoodsBannerResponse appGoodsBannerResp = new AppGoodsBannerResponse();
            appGoodsBannerResp.setId(item.getId());

            Response<BannerResponse> bannerRes = bannerClient.queryByPk(item.getBannerId());

            if (ResponseStatus.Code.SUCCESS == bannerRes.getCode()) {
                BannerResponse data = bannerRes.getData();
                appGoodsBannerResp.setName(data.getTitle());
                appGoodsBannerResp.setBannerUrl(data.getBannerUrl());
            }
            return appGoodsBannerResp;
        }).collect(Collectors.toList()));

        // 2. 分类详情
        List<GoodsClass> goodsClasses = goodsClassMapper.selectList(new LambdaQueryWrapper<GoodsClass>()
                .eq(GoodsClass::getDeleteStatus, Boolean.FALSE)
                .eq(GoodsClass::getParentId, classificationId));

        response.setDetails(goodsClasses.stream().map(item -> {
            AppGoodsClassificationDetailResponse detailResp = new AppGoodsClassificationDetailResponse();
            detailResp.setId(item.getId());
            detailResp.setClassificationId(classificationId);
            detailResp.setName(item.getClassName());

            List<GoodsSpu> spus = goodsSpuMapper.selectList(new LambdaQueryWrapper<GoodsSpu>()
                    .eq(GoodsSpu::getDeleteStatus, Boolean.FALSE)
                    .eq(GoodsSpu::getClassificationId, item.getId()));

            detailResp.setSpus(spus.stream().map(spu -> {
                CommonResponse commonResp = new CommonResponse();
                commonResp.setId(spu.getId());
                commonResp.setName(spu.getSpuName());
                commonResp.setIcon(spu.getSpuImage());
                return commonResp;
            }).collect(Collectors.toList()));
            return detailResp;
        }).collect(Collectors.toList()));

        return Response.toResponse(response);
    }
}
