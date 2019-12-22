package quick.pager.shop.activity.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.activity.fallback.BannerClientFallbackFactory;
import quick.pager.shop.response.Response;

/**
 * banner 服务Client
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = BannerClientFallbackFactory.class)
public interface BannerClient {

    /**
     * 列表
     */
    @RequestMapping(value = "/banner/queryList", method = RequestMethod.POST)
    Response<List<BannerResponse>> queryList(@RequestBody BannerOtherRequest request);

    /**
     * 列表分页
     */
    @RequestMapping(value = "/banner/queryPage", method = RequestMethod.POST)
    Response<List<BannerResponse>> queryPage(@RequestBody BannerPageRequest request);

    /**
     * 新增
     */
    @RequestMapping(value = "/banner/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody BannerSaveRequest request);

    /**
     * 修改
     */
    @RequestMapping(value = "/banner/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody BannerSaveRequest request);

}
