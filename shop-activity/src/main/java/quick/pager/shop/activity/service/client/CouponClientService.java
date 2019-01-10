package quick.pager.shop.activity.service.client;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.activity.client.UserClient;
import quick.pager.shop.activity.mapper.DiscountCouponMapper;
import quick.pager.shop.model.feign.dto.CouponDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.feign.dto.UserInfoDTO;
import quick.pager.shop.model.feign.response.CouponResponse;

/**
 * 用户优惠券服务
 */
@Service
@Slf4j
public class CouponClientService implements IService {

    @Autowired
    private DiscountCouponMapper discountCouponMapper;

    @Autowired
    private UserClient userClient;

    @Override
    public Response doService(DTO dto) {

        CouponDTO couponDTO = (CouponDTO) dto;
        Response response = new Response();

        switch (couponDTO.getEvent()) {
            case Constants.Event.MODIFY:
                break;
            case Constants.Event.LIST:
                response = queryCoupons(couponDTO);
                break;
        }

        return response;
    }

    /**
     * 查询用户优惠券列表
     */
    private Response queryCoupons(CouponDTO couponDTO) {

        PageHelper.startPage(couponDTO.getPage(), couponDTO.getPageSize());
        List<DiscountCoupon> discountCoupons = discountCouponMapper.selectCoupons(couponDTO);

        List<Long> userIds = Lists.newArrayList();

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

        PageInfo<CouponResponse> pageInfo = new PageInfo<>(couponResponses);

        Response<List<CouponResponse>> listResponse = new Response<>();
        listResponse.setData(pageInfo.getList());
        listResponse.setTotal(pageInfo.getTotal());

        return listResponse;
    }
}
