package quick.pager.shop.service.activity;

import java.util.List;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.activity.BannerResponse;

/**
 * banner service
 *
 * @author siguiyang
 */
public interface BannerService {


    Response<List<BannerResponse>> fetch(BannerDTO dto);

    /**
     * 新增
     */
    Response create(BannerDTO dto);

    /**
     * 修改
     */
    Response modify(BannerDTO dto);


    /**
     * 根据banner类型查询列表
     */
    Response listAll(BannerDTO dto);
}
