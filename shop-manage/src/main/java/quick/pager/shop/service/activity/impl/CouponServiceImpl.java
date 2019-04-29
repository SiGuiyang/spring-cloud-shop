package quick.pager.shop.service.activity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.dto.CouponDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.activity.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private ActivityClient activityClient;

    @Override
    public Response publishCoupon(String file, Long templateId) {
        return activityClient.publishCoupon(file, templateId);
    }

    @Override
    public Response coupons(CouponDTO dto) {
        return activityClient.coupons(dto);
    }
}
