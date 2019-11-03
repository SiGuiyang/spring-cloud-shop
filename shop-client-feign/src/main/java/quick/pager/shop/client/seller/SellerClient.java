package quick.pager.shop.client.seller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.fallback.seller.SellerFallbackFactory;
import quick.pager.shop.model.SellerInfo;
import quick.pager.shop.response.Response;

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
    Response<SellerInfo> querySeller(@PathVariable("sellerId") Long sellerId);
}
