package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.CouponTemplateDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.CouponTemplateService;

@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    private ActivityClient activityClient;

    @Override
    public Response template(CouponTemplateDTO dto) {
        return activityClient.template(dto);
    }

    @Override
    public Response modifyTemplate(CouponTemplateDTO dto) {
        return activityClient.modifyTemplate(dto);
    }

    @Override
    public Response addTemplate(CouponTemplateDTO dto) {
        return activityClient.addTemplate(dto);
    }
}
