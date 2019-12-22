package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.model.Banner;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IPageService;

/**
 * Banner 服务
 *
 * @author siguiyang
 */
public interface BannerService extends IPageService<Banner> {

    /**
     * 根据banner类型查询banner列表
     *
     * @param bannerType banner类型
     */
    List<Banner> getBanners(String bannerType);

    /**
     * banner 列表分页
     */
    Response<List<Banner>> queryPage(BannerPageRequest request);

    /**
     * banner 列表
     */
    List<Banner> queryList(BannerOtherRequest request);
}
