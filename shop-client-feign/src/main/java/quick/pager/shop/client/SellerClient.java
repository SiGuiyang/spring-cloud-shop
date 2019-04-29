package quick.pager.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.fallback.SellerFallbackFactory;
import quick.pager.shop.model.SellerInfo;
import quick.pager.shop.response.Response;

/**
 * 商家服务
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-seller", path = Constants.Module.SELLER, fallbackFactory = SellerFallbackFactory.class)
public interface SellerClient {

    /**
     * 查询商家
     *
     * @param sellerId 商家Id
     */
    @PostMapping("/info/{sellerId}")
    Response<SellerInfo> querySeller(@PathVariable("sellerId") Long sellerId);
}
