package quick.pager.shop.manage.service.activity;

import java.util.List;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.manage.param.banner.BannerPageParam;
import quick.pager.shop.manage.param.banner.BannerSaveParam;
import quick.pager.shop.response.Response;

/**
 * banner service
 *
 * @author siguiyang
 */
public interface BannerService {


    Response<List<BannerResponse>> queryPage(BannerPageParam dto);

    /**
     * 新增
     */
    Response<Long> create(BannerSaveParam dto);

    /**
     * 修改
     */
    Response<Long> modify(BannerSaveParam dto);


    /**
     * 根据banner类型查询列表
     */
    Response listAll(BannerPageParam dto);
}
