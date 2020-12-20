package quick.pager.shop.activity.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.activity.request.coupon.DiscountCouponPageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplatePageRequest;
import quick.pager.shop.activity.request.coupon.DiscountCouponTemplateSaveRequest;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.activity.response.coupon.DiscountCouponTemplateResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.activity.fallback.DiscountCouponClientFallbackFactory;
import quick.pager.shop.user.response.Response;

/**
 * 优惠券服务Client
 *
 * @author siguiyang
 * @version 3.0
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = DiscountCouponClientFallbackFactory.class)
public interface DiscountCouponClient {

    /**
     * 优惠券模板列表
     *
     * @param request 请求参数
     * @return 优惠券模板响应数据
     */
    @RequestMapping(value = "/coupon/template/page", method = RequestMethod.POST)
    Response<List<DiscountCouponTemplateResponse>> queryPage(@RequestBody DiscountCouponTemplatePageRequest request);

    /**
     * 优惠券模板新增
     *
     * @param request 请求参数
     * @return 优惠券模板主键
     */
    @RequestMapping(value = "/coupon/template/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody DiscountCouponTemplateSaveRequest request);

    /**
     * 优惠券模板修改
     *
     * @param request 请求参数
     * @return 优惠券模板主键
     */
    @RequestMapping(value = "/coupon/template/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody DiscountCouponTemplateSaveRequest request);

    /**
     * 获取优惠券模板信息
     *
     * @param templateId 优惠券模板主键
     * @return 优惠券模板内容
     */
    @RequestMapping(value = "/coupon/{templateId}/template", method = RequestMethod.GET)
    Response<DiscountCouponTemplateResponse> templateInfo(@PathVariable("templateId") Long templateId);

    /**
     * 优惠券列表
     *
     * @param request 请求参数
     * @return 优惠券列表
     */
    @RequestMapping(value = "/coupon/page", method = RequestMethod.POST)
    Response<List<DiscountCouponResponse>> couponList(@RequestBody DiscountCouponPageRequest request);

    /**
     * 发送优惠券
     *
     * @param templateId 优惠券模板主键
     * @param file       发布文件路径
     * @return 响应数据
     */
    @RequestMapping(value = "/coupon/publish", method = RequestMethod.POST)
    Response publishCoupon(@RequestParam("file") String file, @RequestParam("templateId") Long templateId);

    /**
     * 获取一张优惠券详情
     *
     * @param couponId 优惠券主键
     * @return 优惠券内容
     */
    @RequestMapping(value = "/coupon/{couponId}", method = RequestMethod.GET)
    Response<DiscountCouponResponse> detail(@PathVariable("couponId") Long couponId);


    /**
     * 用户未使用，未过期的优惠券列表
     *
     * @param userId 用户主键
     */
    @RequestMapping(value = "/coupon/{userId}/list", method = RequestMethod.POST)
    Response<List<DiscountCouponResponse>> list(@PathVariable("userId") Long userId);
}
