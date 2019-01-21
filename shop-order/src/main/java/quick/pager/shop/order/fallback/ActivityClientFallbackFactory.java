package quick.pager.shop.order.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.order.client.ActivityClient;

@Slf4j
@Component
public class ActivityClientFallbackFactory implements FallbackFactory<ActivityClient> {
    @Override
    public ActivityClient create(Throwable cause) {
        log.error("ActivityClient 进入熔断错误异常信息 msg = {}", cause.getMessage());
        return new ActivityClient() {
            @Override
            public Response<DiscountCoupon> userCoupons(Long couponId) {
                log.error("进入熔断措施 ActivityClient.userCoupons");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
