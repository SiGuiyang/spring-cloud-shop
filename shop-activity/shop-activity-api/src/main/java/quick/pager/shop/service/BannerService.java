package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerChannelResponse;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.user.response.Response;

/**
 * Banner 服务
 *
 * @author siguiyang
 */
public interface BannerService extends IService<Banner> {

    /**
     * banner 列表分页
     */
    Response<List<BannerResponse>> queryPage(BannerPageRequest request);

    /**
     * banner 列表
     */
    Response<List<BannerResponse>> queryList(BannerOtherRequest request);

    /**
     * 新增
     */
    Response<Long> create(BannerSaveRequest request);

    /**
     * 编辑
     */
    Response<Long> modify(BannerSaveRequest request);

    /**
     * App banner推广
     *
     * @param userId 当前登陆用户主键
     * @param lat    纬度
     * @param lng    经度
     * @return 列表
     */
    Response<List<BannerResponse>> banners(Long userId, String lat, String lng);

    /**
     * 首页banner分享渠道
     * @param id banner 主键
     * @return
     */
    Response<List<BannerChannelResponse>> channel(Long id);
}
