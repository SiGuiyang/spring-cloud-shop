package quick.pager.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.model.activity.Banner;
import quick.pager.shop.response.Response;

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
    Response<List<Banner>> getBanners(String bannerType);

    /**
     * banner 列表
     */
    Response<List<Banner>> list(BannerDTO dto);
}
