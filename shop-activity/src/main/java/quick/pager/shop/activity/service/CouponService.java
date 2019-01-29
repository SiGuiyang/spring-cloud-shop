package quick.pager.shop.activity.service;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.activity.mapper.DiscountCouponMapper;
import quick.pager.shop.activity.response.CouponResponse;
import quick.pager.shop.model.activity.DiscountCoupon;

/**
 * 优惠券列表
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CouponService implements IService<List<CouponResponse>> {
    @Autowired
    private DiscountCouponMapper discountCouponMapper;

    @Override
    public Response<List<CouponResponse>> doService(BaseDTO dto) {


        Integer page = (dto.getPage() - 1) * dto.getPageSize();

        List<DiscountCoupon> discountCoupons = discountCouponMapper.selectCouponsByUserId(dto.getId(), page, dto.getPageSize());
        // 当前时间戳
        long nowTime = DateUtil.current(false);
        List<CouponResponse> result = Lists.newArrayList();
        // 处理未使用，已使用，已过期三大模块
        discountCoupons.forEach(discountCoupon -> {
            CouponResponse couponResponse = new CouponResponse();
            BeanUtils.copyProperties(discountCoupon, couponResponse);
            // 判断是否过期
            long beginTime = discountCoupon.getBeginTime().getTime();
            long endTime = discountCoupon.getEndTime().getTime();

            if (nowTime == Math.max(nowTime, endTime)) { // 已过期
                couponResponse.setOperationType(3);
            } else if (nowTime == Math.max(nowTime, beginTime)) { // 在可用的期限
                if (discountCoupon.getUsed()) { // 是否使用
                    couponResponse.setOperationType(2);
                } else {
                    couponResponse.setOperationType(1);
                }
            } else { //
                couponResponse.setOperationType(1);
            }

            result.add(couponResponse);
        });

        // 最后按照过期的时间开始排序，最先过期排在上面
        result.sort((o1, o2) -> {
            long o1EndTime = o1.getEndTime().getTime();
            long o2EndTime = o2.getEndTime().getTime();

            int index;
            if (o1EndTime == Math.max(o1EndTime, o2EndTime)) {
                index = 1;
            } else {
                index = -1;
            }

            return index;
        });
        Response<List<CouponResponse>> response = new Response<>();
        response.setData(result);
        return response;
    }
}
