package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.enums.CouponTypeEnums;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.mapper.DiscountCouponTemplateMapper;
import quick.pager.shop.activity.response.coupon.CouponResponse;
import quick.pager.shop.model.DiscountCoupon;
import quick.pager.shop.model.DiscountCouponTemplate;
import quick.pager.shop.service.AppDiscountCouponService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.DateUtils;

/**
 * @author siguiyang
 */
@Service
public class AppDiscountCouponServiceImpl implements AppDiscountCouponService {

    @Autowired
    private DiscountCouponTemplateMapper discountCouponTemplateMapper;
    @Autowired
    private DiscountCouponMapper discountCouponMapper;

    @Override
    public Response<List<CouponResponse>> queryCoupons(final Long userId) {

        LambdaQueryWrapper<DiscountCoupon> wrapper = new LambdaQueryWrapper<DiscountCoupon>()
                .ge(DiscountCoupon::getCreateTime, DateUtils.minusMonths(LocalDate.now(), 6))
                .eq(DiscountCoupon::getUserId, userId);

        List<DiscountCoupon> coupons = this.discountCouponMapper.selectList(wrapper);

        if (CollectionUtils.isEmpty(coupons)) {
            return Response.toResponse();
        }

        List<DiscountCouponTemplate> discountCouponTemplates = this.discountCouponTemplateMapper.selectList(new LambdaQueryWrapper<DiscountCouponTemplate>()
                .in(DiscountCouponTemplate::getId, coupons.stream().map(DiscountCoupon::getTemplateId).collect(Collectors.toList()))
                .eq(DiscountCouponTemplate::getState, Boolean.FALSE));

        List<Long> templateIds = discountCouponTemplates.stream().map(DiscountCouponTemplate::getId).collect(Collectors.toList());

        coupons = coupons.stream().filter(item -> templateIds.contains(item.getTemplateId())).collect(Collectors.toList());

        return Response.toResponse(coupons.stream().map(item -> this.convert(item, discountCouponTemplates)).collect(Collectors.toList()));
    }


    private CouponResponse convert(final DiscountCoupon discountCoupon, final List<DiscountCouponTemplate> discountCouponTemplates) {
        return discountCouponTemplates.stream()
                .filter(item -> IConsts.ZERO == discountCoupon.getTemplateId().compareTo(item.getId()))
                .map(item -> CouponResponse.builder()
                        .id(discountCoupon.getId())
                        .name(item.getTemplateName())
                        .valueDesc(item.getCouponAmount().toPlainString())
                        .condition(((CouponTypeEnums.COUPON.getCode().equals(item.getTemplateType())) ? "满" + item.getOrderAmount() + "元" : ""))
                        .unitDesc(((CouponTypeEnums.COUPON.getCode().equals(item.getTemplateType())) ? "元" : "折"))
                        .startAt(discountCoupon.getBeginTime().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())
                        .endAt(discountCoupon.getEndTime().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())
                        .build())
                .findFirst()
                .get();
    }
}
