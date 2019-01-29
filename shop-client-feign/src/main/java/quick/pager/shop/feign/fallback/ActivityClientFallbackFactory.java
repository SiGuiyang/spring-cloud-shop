package quick.pager.shop.feign.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.client.ActivityClient;
import quick.pager.shop.feign.request.BannerRequest;
import quick.pager.shop.feign.request.CouponRequest;
import quick.pager.shop.feign.request.CouponTemplateRequest;
import quick.pager.shop.feign.request.FightGroupRequest;
import quick.pager.shop.model.activity.DiscountCoupon;

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

            @Override
            public Response<DiscountCoupon> userCoupons(Long couponId) {
                log.error("进入熔断措施 ActivityClient.userCoupons");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response fightGroup(FightGroupRequest request) {
                return null;
            }

            @Override
            public Response modify(FightGroupRequest request) {
                return null;
            }

            @Override
            public Response rule(Long groupId) {
                return null;
            }

            @Override
            public Response modifyRule(FightGroupRequest request) {
                return null;
            }

            @Override
            public Response goodsInfo(Long id) {
                return null;
            }

            @Override
            public Response goodsModify(FightGroupRequest request) {
                return null;
            }

            @Override
            public Response records(FightGroupRequest request) {
                return null;
            }

            @Override
            public Response members(Long recordId, Integer page, Integer pageSize) {
                return null;
            }
        };
    }
}
