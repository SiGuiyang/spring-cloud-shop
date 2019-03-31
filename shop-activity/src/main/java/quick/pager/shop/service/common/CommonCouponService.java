package quick.pager.shop.service.common;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.response.Response;
import quick.pager.shop.client.UserClient;
import quick.pager.shop.dto.UserInfoDTO;
import quick.pager.shop.response.CouponResponse;
import quick.pager.shop.model.DiscountCoupon;

/**
 * 优惠券通用服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class CommonCouponService {

    @Autowired
    private UserClient userClient;


    public List<CouponResponse> transCoupon(List<DiscountCoupon> discountCoupons) {
        Set<Long> userIds = Sets.newHashSet();

        List<CouponResponse> couponResponses = Lists.newArrayList();

        discountCoupons.forEach(discountCoupon -> {
            userIds.add(discountCoupon.getUserId());
            CouponResponse couponResponse = new CouponResponse();
            BeanUtils.copyProperties(discountCoupon, couponResponse);
            couponResponses.add(couponResponse);

        });

        // 查询没有结果，也就是没有用户，则不走feign client
        if (!CollectionUtils.isEmpty(userIds)) {
            Long[] longs = new Long[userIds.size()];
            Response<List<UserInfoDTO>> response = userClient.getBatchUser(userIds.toArray(longs));
            log.info("调用user服务返回用户信息 response = {}", JSON.toJSONString(response));
            List<UserInfoDTO> data = response.getData();

            // 迭代遍历，设置用户名
            couponResponses.forEach(couponResponse ->
                    data.forEach(userInfoDTO -> {
                        if (couponResponse.getUserId().compareTo(userInfoDTO.getId()) == 0) {
                            couponResponse.setUsername(userInfoDTO.getUsername());
                        }
                    })
            );
        }

        return couponResponses;
    }
}
