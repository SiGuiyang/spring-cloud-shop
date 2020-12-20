package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.elasticsearch.client.ESUserOrderClient;
import quick.pager.shop.mapper.UserOrderMapper;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.order.enums.OrderStatusEnums;
import quick.pager.shop.order.request.SubmitOrderRequest;
import quick.pager.shop.order.response.AppUserOrderResponse;
import quick.pager.shop.param.AppUserOrderEvaluateParam;
import quick.pager.shop.order.response.UserOrderQuantityResponse;
import quick.pager.shop.service.AppUserOrderService;
import quick.pager.shop.user.response.Response;

/**
 * AppUserOrderService 实现
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class AppUserOrderServiceImpl implements AppUserOrderService {

    @Autowired
    private ESUserOrderClient esUserOrderClient;

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public Response<UserOrderQuantityResponse> quantity(final Long userId) {
        log.info("用户订单气泡数 userId = {}", userId);
        // APP 订单展示气泡数状态条件
        List<String> orderStatus = Stream.of(OrderStatusEnums.BS001.getCode(), OrderStatusEnums.BS002.getCode(), OrderStatusEnums.BS003.getCode(),
                OrderStatusEnums.BS004.getCode(), OrderStatusEnums.BS005.getCode(), OrderStatusEnums.BS007.getCode()).collect(Collectors.toList());
        // 查询用户订单总条数
        List<UserOrder> userOrders = userOrderMapper.selectList(new LambdaQueryWrapper<UserOrder>()
                .eq(UserOrder::getDeleteStatus, Boolean.FALSE)
                .eq(UserOrder::getUserId, userId)
                .in(UserOrder::getOrderStatus, orderStatus));

        return null;
    }

    @Override
    public Response<AppUserOrderResponse> orders(final Long userId, final Integer page, final String order) {
        return Response.toResponse();
    }

    @Override
    public Response detail(final Long userId, final Long orderId) {
        return null;
    }

    @Override
    public Response evaluate(final Long userId, final Long orderId, final AppUserOrderEvaluateParam param) {
        return null;
    }

    @Override
    public Response cancel(final Long userId, final Long orderId) {
        return null;
    }

    @Override
    public Response refund(final Long userId, final Long orderId) {
        return null;
    }

    @Override
    public Response confirm(final Long userId, final Long orderId) {
        return null;
    }

    @Override
    public Response submit(final SubmitOrderRequest request) {
        return null;
    }
}
