package quick.pager.shop.manage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.common.response.Response;
import quick.pager.shop.manage.fallback.ActivityClientFallback;
import quick.pager.shop.model.feign.request.BannerRequest;
import quick.pager.shop.model.feign.request.CouponRequest;
import quick.pager.shop.model.feign.request.CouponTemplateRequest;

/**
 * 活动模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-activity",fallback = ActivityClientFallback.class)
public interface ActivityClient {

    @RequestMapping(value = "/activity/banner/fetch", method = RequestMethod.POST)
    Response fetch(@RequestBody BannerRequest request);

    @RequestMapping(value = "/activity/banner/modify", method = RequestMethod.POST)
    Response modify(@RequestBody BannerRequest request);

    @RequestMapping(value = "/activity/publish/coupon", method = RequestMethod.POST)
    Response publishCoupon(@RequestParam("file") String file, @RequestParam("templateId") Long templateId);

    @RequestMapping(value = "/activity/coupon/template", method = RequestMethod.POST)
    Response template(@RequestBody CouponTemplateRequest request);

    @RequestMapping(value = "/activity/coupon/template/modify", method = RequestMethod.POST)
    Response modifyTemplate(@RequestBody CouponTemplateRequest request);

    @RequestMapping(value = "/activity/coupon/list", method = RequestMethod.POST)
    Response coupons(@RequestBody CouponRequest request);
}
