package quick.pager.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.BannerDTO;
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.dto.CouponTemplateDTO;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.dto.FightGroupDTO;
import quick.pager.shop.fallback.ActivityClientFallbackFactory;
import quick.pager.shop.response.Response;
import quick.pager.shop.model.DiscountCoupon;

/**
 * 活动模块
 *
 * @author siguiyang
 */
@FeignClient(value = "shop-activity", path = Constants.Module.ACTIVITY, fallbackFactory = ActivityClientFallbackFactory.class)
public interface ActivityClient {

    @RequestMapping(value = "/banner/list", method = RequestMethod.POST)
    Response fetch(@RequestBody BannerDTO dto);

    /**
     * 修改
     */
    @RequestMapping(value = "/banner/modify", method = RequestMethod.PUT)
    Response addBanner(@RequestBody BannerDTO dto);

    /**
     * 新增
     */
    @RequestMapping(value = "/banner/modify", method = RequestMethod.POST)
    Response modifyBanner(@RequestBody BannerDTO dto);

    /**
     * 发送优惠券
     */
    @RequestMapping(value = "/publish/coupon", method = RequestMethod.POST)
    Response publishCoupon(@RequestParam("file") String file, @RequestParam("templateId") Long templateId);

    /**
     * 优惠券模板列表
     */
    @RequestMapping(value = "/coupon/template", method = RequestMethod.POST)
    Response template(@RequestBody CouponTemplateDTO dto);

    /**
     * 优惠券模板修改
     */
    @RequestMapping(value = "/coupon/template/modify", method = RequestMethod.PUT)
    Response modifyTemplate(@RequestBody CouponTemplateDTO dto);

    /**
     * 优惠券模板新增
     */
    @RequestMapping(value = "/coupon/template/modify", method = RequestMethod.POST)
    Response addTemplate(@RequestBody CouponTemplateDTO dto);

    @RequestMapping(value = "/coupon/list", method = RequestMethod.POST)
    Response coupons(@RequestBody CouponDTO dto);

    /**
     * 获取一张优惠券详情
     */
    @RequestMapping(value = "/coupon/{couponId}", method = RequestMethod.POST)
    Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId);

    /**
     * 拼团活动列表
     */
    @RequestMapping(value = "/fightGroup/list", method = RequestMethod.POST)
    Response fightGroupActivityList(@RequestBody FightGroupDTO request);

    /**
     * 拼团活动新增
     */
    @RequestMapping(value = "/fightGroup/modify", method = RequestMethod.POST)
    Response addFightGroupActivity(@RequestBody FightGroupDTO dto);

    /**
     * 拼团活动修改
     */
    @RequestMapping(value = "/fightGroup/modify", method = RequestMethod.PUT)
    Response modifyFightGroupActivity(@RequestBody FightGroupDTO dto);

    /**
     * 拼团活动规则详情
     */
    @RequestMapping(value = "/fightGroup/rule/{activityId}", method = RequestMethod.POST)
    Response fightGroupActivityRuleInfo(@PathVariable("activityId") Long activityId);

    /**
     * 拼团活动规则新增或者修改
     */
    @RequestMapping(value = "/fightGroup/rule/modify", method = RequestMethod.POST)
    Response modifyFightGroupRule(@RequestBody FightGroupDTO dto);

    /**
     * 拼团活动商品详情
     */
    @RequestMapping(value = "/fightGroup/goods/{activityId}", method = RequestMethod.POST)
    Response fightGroupGoodsInfo(@PathVariable("activityId") Long activityId);

    /**
     * 拼团规则的商品
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/fightGroup/goods/modify", method = RequestMethod.PUT)
    Response setFightGroupGoods(@RequestParam("activityId") Long activityId, @RequestParam("goodsId") Long goodsId);

    /**
     * 查询当前活动的商品是否存在
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/fight/goods/{activityId}/{goodsId}")
    Response queryFightGroupGoods(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId);

    /**
     * 拼团成团记录
     */
    @RequestMapping(value = "/fightGroup/members", method = RequestMethod.POST)
    Response fightGroupRecords(@RequestBody FightGroupDTO dto);

    /**
     * 获取活动
     * @param activityId 活动Id
     */
    @GetMapping("/exchange/{activityId}")
    Response getExchangeActivity(@PathVariable("activityId") Long activityId);

    /**
     * 满赠换购列表
     */
    @RequestMapping(value = "/exchange/list", method = RequestMethod.POST)
    Response getExchangeActivitys(@RequestBody ExchangeActivityDTO dto);

    /**
     * 添加满赠换购活动
     */
    @RequestMapping(value = "/exchange", method = RequestMethod.POST)
    Response addExchangeActivitys(@RequestBody ExchangeActivityDTO dto);

    /**
     * 添加满赠换购活动
     */
    @RequestMapping(value = "/exchange", method = RequestMethod.PUT)
    Response modifyExchangeActivitys(@RequestBody ExchangeActivityDTO dto);

    /**
     * 活动规则列表
     */
    @RequestMapping(value = "/exchange/rule/list", method = RequestMethod.POST)
    Response getExchangeActivityRules(@RequestBody ExchangeActivityDTO dto);

    /**
     * 活动规则新增
     */
    @RequestMapping(value = "/exchange/rule", method = RequestMethod.POST)
    Response addExchangeActivityRules(@RequestBody ExchangeActivityDTO dto);

    /**
     * 活动规则修改
     */
    @RequestMapping(value = "/exchange/rule", method = RequestMethod.PUT)
    Response modifyExchangeActivityRules(@RequestBody ExchangeActivityDTO dto);

    /**
     * 购买记录
     */
    Response purchaseHistory(ExchangeActivityDTO dto);
}
