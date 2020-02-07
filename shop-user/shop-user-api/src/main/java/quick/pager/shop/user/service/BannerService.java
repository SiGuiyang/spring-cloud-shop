package quick.pager.shop.user.service;

import java.util.List;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.response.Response;

/**
 * Banner 服务
 *
 * @author siguiyang
 */
public interface BannerService {

    /**
     * 消费者端Banner 列表
     *
     * @return banner 列表数据
     */
    Response<List<BannerResponse>> queryList();
}
