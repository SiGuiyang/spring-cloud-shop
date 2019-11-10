package quick.pager.shop.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.AppDTO;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.DiscountCouponService;
import quick.pager.shop.service.GiftCouponService;
import quick.pager.shop.utils.DateUtils;

/**
 * 优惠券接口
 *
 * @author siguiyang
 */
@RestController
@Slf4j
@RequestMapping(Constants.Module.ACTIVITY)
public class CouponController {

    @Autowired
    private GiftCouponService giftCouponService;

    @Autowired
    private DiscountCouponService discountCouponService;

    /**
     * 用户优惠券列表
     */
    @PostMapping("/coupon/list")
    public Response<List<DiscountCoupon>> coupons(@RequestBody CouponDTO dto) {

        if (!CollectionUtils.isEmpty(dto.getTimeRange())) {
            dto.setBeginTime(DateUtils.parseDateTime(dto.getTimeRange().get(0)));
            dto.setEndTime(DateUtils.parseDateTime(dto.getTimeRange().get(1)));
        }
        return discountCouponService.list(dto);
    }

    /**
     * 获取一张优惠券详情
     */
    @PostMapping("/coupon/{couponId}")
    public Response<DiscountCoupon> userCoupons(@PathVariable("couponId") Long couponId) {

        return discountCouponService.info(couponId);
    }

    /**
     * 赠送优惠券
     */
    @PostMapping("/coupon/gift/{userId}")
    public Response giftCoupon(@PathVariable("userId") Long userId) {
        AppDTO appDTO = new AppDTO();
        appDTO.setUserId(userId);
        return giftCouponService.doService(appDTO);
    }

    /**
     * 发送优惠券
     */
    @PostMapping("/coupon/publish")
    public Response publishCoupon(@RequestParam String file, @RequestParam Long templateId) {
        return discountCouponService.publish(file, templateId);
    }

}
