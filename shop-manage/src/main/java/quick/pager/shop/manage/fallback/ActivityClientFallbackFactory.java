package quick.pager.shop.manage.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.client.ActivityClient;
import quick.pager.shop.model.feign.request.BannerRequest;
import quick.pager.shop.model.feign.request.CouponRequest;
import quick.pager.shop.model.feign.request.CouponTemplateRequest;

/**
 * 活动模块熔断工厂
 *
 * @author siguiyang
 */
@Slf4j
@Component
public class ActivityClientFallbackFactory implements FallbackFactory<ActivityClient> {
    @Override
    public ActivityClient create(Throwable cause) {
        log.error("ActivityClient 进入熔断错误异常信息 msg = {}", cause.getMessage());
        return new ActivityClient() {
            @Override
            public Response fetch(BannerRequest request) {
                log.error("进入熔断措施 ActivityClient.fetch");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modify(BannerRequest request) {
                log.error("进入熔断措施 ActivityClient.modify");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response publishCoupon(String file, Long templateId) {
                log.error("进入熔断措施 ActivityClient.publishCoupon");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response template(CouponTemplateRequest request) {
                log.error("进入熔断措施 ActivityClient.template");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modifyTemplate(CouponTemplateRequest request) {
                log.error("进入熔断措施 ActivityClient.modifyTemplate");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response coupons(CouponRequest request) {
                log.error("进入熔断措施 ActivityClient.coupons");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }
        };
    }
}
