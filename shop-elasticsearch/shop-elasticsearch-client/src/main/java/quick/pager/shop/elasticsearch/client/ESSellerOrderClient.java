package quick.pager.shop.elasticsearch.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.elasticsearch.request.ESSellerOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESSellerOrderResponse;
import quick.pager.shop.user.response.Response;

/**
 * 商户ES订单
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ELASTICSEARCH_CLIENT, path = ConstantsClient.ELASTICSEARCH)
public interface ESSellerOrderClient {

    /**
     * 订单查询
     *
     * @param request 请求参数
     */
    @RequestMapping(value = "/seller/order/page", method = RequestMethod.POST)
    public Response<List<ESSellerOrderResponse>> queryPage(@RequestBody final ESSellerOrderPageRequest request);
}
