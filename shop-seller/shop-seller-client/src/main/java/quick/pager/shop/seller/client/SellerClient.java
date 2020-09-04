package quick.pager.shop.seller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.seller.fallback.SellerFallbackFactory;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.response.SellerInfoResponse;

/**
 * 商家服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.SELLER_CLIENT, path = ConstantsClient.SELLER, fallbackFactory = SellerFallbackFactory.class)
public interface SellerClient {

    /**
     * 查询商家
     *
     * @param sellerId 商家Id
     */
    @RequestMapping(value = "/{sellerId}/info", method = RequestMethod.POST)
    Response<SellerInfoResponse> querySeller(@PathVariable("sellerId") Long sellerId);
}
