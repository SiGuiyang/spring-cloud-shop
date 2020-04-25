package quick.pager.shop.activity.fallback;

import feign.hystrix.FallbackFactory;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.activity.client.BannerClient;
import quick.pager.shop.activity.request.banner.BannerOtherRequest;
import quick.pager.shop.activity.request.banner.BannerPageRequest;
import quick.pager.shop.activity.request.banner.BannerSaveRequest;
import quick.pager.shop.activity.response.banner.BannerResponse;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;

/**
 * banner模块熔断工厂
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class BannerClientFallbackFactory implements FallbackFactory<BannerClient> {

    @Override
    public BannerClient create(Throwable cause) {
        return new BannerClient() {
            @Override
            public Response<BannerResponse> queryByPk(Long id) {
                log.error(cause.getMessage());
                return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
            }

            @Override
            public Response<List<BannerResponse>> queryList(BannerOtherRequest request) {
                return null;
            }

            @Override
            public Response<List<BannerResponse>> queryPage(BannerPageRequest request) {
                return null;
            }

            @Override
            public Response<Long> create(BannerSaveRequest request) {
                return null;
            }

            @Override
            public Response<Long> modify(BannerSaveRequest request) {
                return null;
            }
        };
    }
}
