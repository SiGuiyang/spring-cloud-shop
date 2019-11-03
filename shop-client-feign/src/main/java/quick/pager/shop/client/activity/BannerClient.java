package quick.pager.shop.client.activity;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.activity.BannerDTO;
import quick.pager.shop.fallback.activity.BannerClientFallbackFactory;
import quick.pager.shop.model.activity.Banner;
import quick.pager.shop.response.Response;

/**
 * banner 服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = BannerClientFallbackFactory.class)
public interface BannerClient {

    @RequestMapping(value = "/banner/list", method = RequestMethod.POST)
    Response<List<Banner>> fetch(@RequestBody BannerDTO dto);

    /**
     * 新增
     */
    @RequestMapping(value = "/banner/create", method = RequestMethod.POST)
    Response create(@RequestBody BannerDTO dto);

    /**
     * 修改
     */
    @RequestMapping(value = "/banner/modify", method = RequestMethod.PUT)
    Response modify(@RequestBody BannerDTO dto);


    /**
     * 根据banner类型查询列表
     */
    @RequestMapping(value = "/banner/listAll", method = RequestMethod.POST)
    Response listAll(@RequestBody BannerDTO bannerDTO);

}
