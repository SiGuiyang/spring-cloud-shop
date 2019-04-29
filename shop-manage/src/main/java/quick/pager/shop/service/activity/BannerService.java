package quick.pager.shop.service.activity;

import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.response.Response;

/**
 * banner 服务
 */
public interface BannerService {
    /**
     * banner 列表
     */
    Response fetch(BannerDTO dto);

    /**
     * 添加banner
     */
    Response addBanner(BannerDTO dto);

    /**
     * 修改banner
     */
    Response modifyBanner(BannerDTO dto);
}
