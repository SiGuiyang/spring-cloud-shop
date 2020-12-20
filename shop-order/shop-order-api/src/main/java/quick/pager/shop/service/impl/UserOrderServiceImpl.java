package quick.pager.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.mapper.UserOrderMapper;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.order.request.OrderPageRequest;
import quick.pager.shop.order.response.UserOrderResponse;
import quick.pager.shop.user.client.UserClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.UserOrderService;
import quick.pager.shop.utils.Assert;

@Service
@Slf4j
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

    @Autowired
    private UserClient userClient;

    @Override
    public Response<List<UserOrderResponse>> queryPage(final OrderPageRequest request) {
        log.info("用户订单列表 params = {}", JSON.toJSONString(request));

        LambdaQueryWrapper<UserOrder> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(request.getPhone())) {
            wrapper.eq(UserOrder::getPhone, request.getPhone());
        }
        if (StringUtils.isNotEmpty(request.getOrderCode())) {
            wrapper.eq(UserOrder::getOrderCode, request.getOrderCode());
        }
        if (CollectionUtils.isNotEmpty(request.getOrderStatus())) {
            wrapper.in(UserOrder::getOrderStatus, request.getOrderStatus());
        }
        if (CollectionUtils.isNotEmpty(request.getOrderType())) {
            wrapper.in(UserOrder::getOrderType, request.getOrderType());
        }
        if (CollectionUtils.isNotEmpty(request.getTimeRange())) {
            wrapper.ge(UserOrder::getCreateTime, request.getTimeRange().get(IConsts.ZERO));
            wrapper.le(UserOrder::getCreateTime, request.getTimeRange().get(IConsts.ONE));
        }

        Response<List<UserOrder>> page = this.toPage(request.getPage(), request.getPageSize(), wrapper);
        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()), page.getTotal());
    }

    @Override
    public Response<Object> detail(final Long orderId) {

        UserOrder userOrder = this.baseMapper.selectById(orderId);

        Assert.isTrue(Objects.nonNull(userOrder), () -> "订单不存在");


        return Response.toResponse(userOrder);
    }

    private UserOrderResponse convert(final UserOrder userOrder) {

        UserOrderResponse response = new UserOrderResponse();
        response.setId(userOrder.getId());
        response.setAddrId(userOrder.getAddrId());
        response.setCouponId(userOrder.getCouponId());
        response.setDiscountAmount(userOrder.getDiscountAmount());
        response.setIntegralAmount(userOrder.getIntegralAmount());
        response.setOrderAmount(userOrder.getOrderAmount());
        response.setOrderCode(userOrder.getOrderCode());
        response.setOrderType(userOrder.getOrderType());
        response.setPhone(userOrder.getPhone());
        response.setSelf(userOrder.getSelf());
        response.setSellerId(userOrder.getSellerId());
        response.setUserId(userOrder.getUserId());
        response.setIntegral(userOrder.getIntegral());
        response.setPayAmount(userOrder.getPayAmount());
        response.setCreateTime(userOrder.getCreateTime());

        return response;
    }

}
