package quick.pager.shop.service.activity.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.activity.DiscountCouponClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.activity.DiscountCouponTemplate;
import quick.pager.shop.response.DiscountCouponResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.CouponService;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.CopyOptions;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private DiscountCouponClient discountCouponClient;

    @Override
    public Response publishCoupon(String file, Long templateId) {
        return discountCouponClient.publishCoupon(file, templateId);
    }

    @Override
    public Response coupons(CouponDTO dto) {
        Response<List<DiscountCoupon>> coupons = discountCouponClient.coupons(dto);

        if (ResponseStatus.Code.SUCCESS != coupons.getCode()) {
            return new Response(coupons.getCode(), coupons.getMsg());
        }

        List<DiscountCoupon> data = coupons.getData();
        List<DiscountCouponResponse> collect = Optional.ofNullable(data).orElse(Collections.emptyList())
                .stream().map(this::convert).collect(Collectors.toList());

        return Response.toResponse(collect, coupons.getTotal());
    }

    private DiscountCouponResponse convert(DiscountCoupon coupon) {
        DiscountCouponResponse response = new DiscountCouponResponse();
        response.setId(coupon.getId());
        response.setPhone(coupon.getPhone());
        response.setTemplateId(coupon.getTemplateId());
        response.setUsed(coupon.getUsed());
        response.setUsed(coupon.getUsed());

        BeanCopier.create(coupon, response, CopyOptions.create().setIgnoreError(true).setIgnoreNullValue(true)).copy();

        Response<DiscountCouponTemplate> templateResponse = discountCouponClient.templateInfo(coupon.getTemplateId());
        if (ResponseStatus.Code.SUCCESS != templateResponse.getCode()) {
            return null;
        }

        DiscountCouponTemplate data = templateResponse.getData();
        BeanCopier.create(data, response, CopyOptions.create().setIgnoreError(true).setIgnoreNullValue(true)).copy();
        response.setCreateTime(coupon.getCreateTime());
        return response;
    }
}
