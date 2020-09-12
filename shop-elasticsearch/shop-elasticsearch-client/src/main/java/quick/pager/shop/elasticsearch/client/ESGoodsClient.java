package quick.pager.shop.elasticsearch.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.elasticsearch.request.ESGoodsPageRequest;
import quick.pager.shop.elasticsearch.response.ESGoodsResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商品ES服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ELASTICSEARCH_CLIENT, path = ConstantsClient.ELASTICSEARCH)
public interface ESGoodsClient {

    /**
     * 查询商品
     *
     * @param request 请求参数
     */
    @RequestMapping(value = "/goods/page", method = RequestMethod.POST)
    public Response<List<ESGoodsResponse>> queryPage(@RequestBody final ESGoodsPageRequest request);
}
