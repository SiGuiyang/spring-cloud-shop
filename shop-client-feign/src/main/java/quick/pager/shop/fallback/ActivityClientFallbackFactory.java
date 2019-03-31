package quick.pager.shop.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.dto.CouponTemplateDTO;
import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.model.DiscountCoupon;

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
            public Response fetch(BannerDTO dto) {
                log.error("进入熔断措施 ActivityClient.fetch");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modify(BannerDTO dto) {
                log.error("进入熔断措施 ActivityClient.modify");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response publishCoupon(String file, Long templateId) {
                log.error("进入熔断措施 ActivityClient.publishCoupon");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response template(CouponTemplateDTO dto) {
                log.error("进入熔断措施 ActivityClient.template");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response modifyTemplate(CouponTemplateDTO dto) {
                log.error("进入熔断措施 ActivityClient.modifyTemplate");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response coupons(CouponDTO dto) {
                log.error("进入熔断措施 ActivityClient.coupons");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response<DiscountCoupon> userCoupons(Long couponId) {
                log.error("进入熔断措施 ActivityClient.userCoupons");
                return new Response<>(ResponseStatus.Code.EXCEPTION_CODE, ResponseStatus.TELNET_EXCEPTION);
            }

            @Override
            public Response fightGroup(FightGroupDTO dto) {
                return null;
            }

            @Override
            public Response modify(FightGroupDTO dto) {
                return null;
            }

            @Override
            public Response rule(Long groupId) {
                return null;
            }

            @Override
            public Response modifyRule(FightGroupDTO dto) {
                return null;
            }

            @Override
            public Response goodsInfo(Long id) {
                return null;
            }

            @Override
            public Response goodsModify(FightGroupDTO dto) {
                return null;
            }

            @Override
            public Response records(FightGroupDTO dto) {
                return null;
            }

            @Override
            public Response members(Long recordId, Integer page, Integer pageSize) {
                return null;
            }
        };
    }
}
