package quick.pager.shop.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.common.constants.Constants;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.dto.BannerDTO;
import quick.pager.shop.feign.dto.CouponDTO;
import quick.pager.shop.feign.dto.CouponTemplateDTO;
import quick.pager.shop.feign.fallback.ActivityClientFallbackFactory;
import quick.pager.shop.feign.dto.FightGroupDTO;
import quick.pager.shop.model.activity.DiscountCoupon;

/**
 * 活动模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-activity", path = Constants.Module.ACTIVITY, fallbackFactory = ActivityClientFallbackFactory.class)
public interface ActivityClient {

    @RequestMapping(value = "/banner/fetch", method = RequestMethod.POST)
    Response fetch(@RequestBody BannerDTO dto);

    @RequestMapping(value = "/banner/modify", method = RequestMethod.POST)
    Response modify(@RequestBody BannerDTO dto);

    @RequestMapping(value = "/publish/coupon", method = RequestMethod.POST)
    Response publishCoupon(@RequestParam("file") String file, @RequestParam("templateId") Long templateId);

    @RequestMapping(value = "/coupon/template", method = RequestMethod.POST)
    Response template(@RequestBody CouponTemplateDTO dto);

    @RequestMapping(value = "/coupon/template/modify", method = RequestMethod.POST)
    Response modifyTemplate(@RequestBody CouponTemplateDTO dto);

    @RequestMapping(value = "/coupon/list", method = RequestMethod.POST)
    Response coupons(@RequestBody CouponDTO dto);

    /**
     * 获取一张优惠券详情
     */
    @RequestMapping(value = "/userCoupons/{couponId}", method = RequestMethod.POST)
    Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId);

    // 拼团活动列表
    @RequestMapping(value = "/fightGroup/list", method = RequestMethod.POST)
    Response fightGroup(@RequestBody FightGroupDTO request);

    // 拼团活动修改新增
    @RequestMapping(value = "/fight/modify", method = RequestMethod.POST)
    Response modify(@RequestBody FightGroupDTO dto);

    // 拼团活动规则详情
    @RequestMapping(value = "/fightGroup/rule/{groupId}", method = RequestMethod.POST)
    Response rule(@PathVariable("groupId") Long groupId);

    // 拼团活动规则
    @RequestMapping(value = "/fightGroup/rule/modify", method = RequestMethod.POST)
    Response modifyRule(@RequestBody FightGroupDTO dto);

    // 活动商品详情
    @RequestMapping(value = "/fightGroup/goods/{groupId}", method = RequestMethod.POST)
    Response goodsInfo(@PathVariable("groupId") Long groupId);

    // 拼团规则的商品
    @RequestMapping(value = "/fightGroup/goods/modify", method = RequestMethod.POST)
    Response goodsModify(@RequestBody FightGroupDTO dto);

    // 成团记录
    @RequestMapping(value = "/fightGroup/records", method = RequestMethod.POST)
    Response records(@RequestBody FightGroupDTO dto);

    // 参与成团人员
    @RequestMapping(value = "/fightGroup/members", method = RequestMethod.POST)
    Response members(@RequestParam("recordId") Long recordId, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize);

}
