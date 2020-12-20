package quick.pager.shop.seller.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.seller.client.SellerClient;
import quick.pager.shop.response.SellerInfoResponse;

@Slf4j
@Component
public class SellerFallbackFactory implements FallbackFactory<SellerClient> {
    @Override
    public SellerClient create(Throwable cause) {
        return new SellerClient() {
            @Override
            public Response<SellerInfoResponse> querySeller(Long sellerId) {
                return Response.toError(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }
        };
    }
}
