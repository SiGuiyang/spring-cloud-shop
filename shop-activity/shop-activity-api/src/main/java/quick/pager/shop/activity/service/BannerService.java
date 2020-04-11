package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.response.Response;

/**
 * Banner 服务
 *
 * @author siguiyang
 */
public interface BannerService {

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
}
