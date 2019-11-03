package quick.pager.shop.fallback.seller;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.client.seller.SellerClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.model.SellerInfo;
import quick.pager.shop.response.Response;

@Slf4j
@Component
public class SellerFallbackFactory implements FallbackFactory<SellerClient> {
    @Override
    public SellerClient create(Throwable cause) {
        return new SellerClient() {
            @Override
            public Response<SellerInfo> querySeller(Long sellerId) {
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }
        };
    }
}
