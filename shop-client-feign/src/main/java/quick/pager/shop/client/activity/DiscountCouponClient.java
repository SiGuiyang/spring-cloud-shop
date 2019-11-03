package quick.pager.shop.client.activity;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.dto.activity.CouponTemplateDTO;
import quick.pager.shop.fallback.activity.DiscountCouponClientFallbackFactory;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.activity.DiscountCouponTemplate;
import quick.pager.shop.response.Response;

/**
 * 优惠券服务
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = DiscountCouponClientFallbackFactory.class)
public interface DiscountCouponClient {

    /**
     * 发送优惠券
     */
    @RequestMapping(value = "/coupon/publish", method = RequestMethod.POST)
    Response publishCoupon(@RequestParam("file") String file, @RequestParam("templateId") Long templateId);

    /**
     * 优惠券模板列表
     */
    @RequestMapping(value = "/coupon/template/list", method = RequestMethod.POST)
    Response template(@RequestBody CouponTemplateDTO dto);

    /**
     * 优惠券模板修改
     */
    @RequestMapping(value = "/coupon/template/modify", method = RequestMethod.PUT)
    Response modifyTemplate(@RequestBody CouponTemplateDTO dto);

    /**
     * 获取优惠券模板信息
     */
    @RequestMapping(value = "/coupon/template/{templateId}", method = RequestMethod.GET)
    Response<DiscountCouponTemplate> templateInfo(@PathVariable("templateId") Long templateId);

    /**
     * 优惠券模板新增
     */
    @RequestMapping(value = "/coupon/template/create", method = RequestMethod.POST)
    Response addTemplate(@RequestBody CouponTemplateDTO dto);

    @RequestMapping(value = "/coupon/list", method = RequestMethod.POST)
    Response<List<DiscountCoupon>> coupons(@RequestBody CouponDTO dto);

    /**
     * 获取一张优惠券详情
     */
    @RequestMapping(value = "/coupon/{couponId}", method = RequestMethod.POST)
    Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId);
}
