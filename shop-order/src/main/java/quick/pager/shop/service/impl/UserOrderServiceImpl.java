package quick.pager.shop.service.impl;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.mapper.UserOrderMapper;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.response.OrderResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.UserOrderService;
import quick.pager.shop.service.common.CommonOrderService;

@Service
@Slf4j
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private CommonOrderService commonOrderService;

    @Override
    public Response<List<OrderResponse>> userOrderList(OrderDTO dto) {

        Integer page = (dto.getPage() - 1) * dto.getPageSize();

        // 获取订单
        List<UserOrder> userOrders = userOrderMapper.selectOrders(dto.getUserId(),
                dto.getPhone(),
                dto.getOrderCode(),
                getOrderStatus(dto.getOrder(), dto.getOrderStatus()),
                dto.getOrderType(),
                dto.getBeginTime(),
                dto.getEndTime());
        // 查询总数
        long count = userOrderMapper.selectCountOrders(dto.getUserId(),
                dto.getPhone(),
                dto.getOrderCode(),
                getOrderStatus(dto.getOrder(), dto.getOrderStatus()),
                dto.getOrderType(),
                dto.getBeginTime(),
                dto.getEndTime(),
                page,
                dto.getPageSize());

        List<OrderResponse> orderResponses = Lists.newArrayListWithCapacity(userOrders.size());
        userOrders.forEach(userOrder -> {
            OrderResponse orderResponse = commonOrderService.transOrder(userOrder);
            orderResponses.add(orderResponse);
        });

        return Response.toResponse(orderResponses, count);
    }

    /**
     * 根据查询的order，获取orderStatus
     *
     * @param order       查询order
     * @param orderStatus 订单状态
     */
    private List<String> getOrderStatus(Integer order, String orderStatus) {

        List<String> result = null;
        orderStatus = Optional.ofNullable(orderStatus).orElse("");
        if (null != order) {
            switch (order) {
                case 1:
                    return Collections.singletonList(orderStatus);
                case 2:
                    result = Arrays.asList(Constants.OrderStatus.BS001.getStatus(), orderStatus);
                    break;
                case 3:
                    result = Arrays.asList(Constants.OrderStatus.BS002.getStatus(), Constants.OrderStatus.BS003.getStatus(), Constants.OrderStatus.BS003.getStatus(), orderStatus);
                    break;
                case 4:
                    result = Arrays.asList(Constants.OrderStatus.BS007.getStatus(), orderStatus);
                    break;
                case 5:
                    result = Arrays.asList(Constants.OrderStatus.BS006.getStatus(), orderStatus);
                    break;
            }
        }
        return result;

    }

    @Override
    public Response<OrderResponse> userOrderDetail(Long orderId) {
        UserOrder userOrder = userOrderMapper.selectByPrimaryKey(orderId);

        return new Response<>(commonOrderService.transOrder(userOrder));
    }

    @Override
    public Response orderCreate(UserOrder userOrder) {
        int result = userOrderMapper.insertSelective(userOrder);

        if (result > 0) {
            return new Response();
        }
        return new Response(ResponseStatus.Code.FAIL_CODE, "创建订单失败");
    }
}
