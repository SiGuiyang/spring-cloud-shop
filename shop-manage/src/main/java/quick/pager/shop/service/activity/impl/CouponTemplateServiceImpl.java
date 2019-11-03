package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.activity.DiscountCouponClient;
import quick.pager.shop.dto.activity.CouponTemplateDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.CouponTemplateService;

@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    private DiscountCouponClient discountCouponClient;

    @Override
    public Response template(CouponTemplateDTO dto) {
        return discountCouponClient.template(dto);
    }

    @Override
    public Response modifyTemplate(CouponTemplateDTO dto) {
        return discountCouponClient.modifyTemplate(dto);
    }

    @Override
    public Response addTemplate(CouponTemplateDTO dto) {
        return discountCouponClient.addTemplate(dto);
    }
}
