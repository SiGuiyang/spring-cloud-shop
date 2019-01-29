package quick.pager.shop.order.service;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.feign.client.GoodsClient;
import quick.pager.shop.feign.response.GoodsResponse;
import quick.pager.shop.feign.response.OrderResponse;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.order.dto.OrderDTO;
import quick.pager.shop.order.mapper.UserOrderMapper;

/**
 * 订单列表
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class OrderListService implements IService<List<OrderResponse>> {

    @Autowired
    private UserOrderMapper orderMapper;
    @Autowired
    private GoodsClient goodsClient;

    @Override
    public Response<List<OrderResponse>> doService(DTO dto) {

        OrderDTO orderDTO = (OrderDTO) dto;


        List<String> orderStatus = getOrderStatus(orderDTO.getOrder());
        Integer page = (orderDTO.getPage() - 1) * orderDTO.getPageSize();
        List<UserOrder> userOrders = orderMapper.selectOrders(orderDTO.getUserId(), orderStatus, page, orderDTO.getPageSize());

        List<OrderResponse> orderResponses = Lists.newArrayListWithCapacity(userOrders.size());
        userOrders.forEach(userOrder -> {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setUserOrder(userOrder);
            Response<List<GoodsResponse>> response = goodsClient.queryBuyerOrderGoods(userOrder.getBuyOrderCartId());
            orderResponse.setBuyerGoods(response.getData());
            orderResponses.add(orderResponse);
        });

        return new Response<>(orderResponses);
    }

    /**
     * 获取需要查询的订单状态集合
     * <p>
     * 所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5
     */
    private List<String> getOrderStatus(String order) {

        switch (order) {
            case Constants.Common.ONE:
                return null;
            case Constants.Common.TWO:
                return Collections.singletonList(Constants.OrderStatus.BS001.getStatus());
            case Constants.Common.THREE:
                return Arrays.asList(Constants.OrderStatus.BS002.getStatus(), Constants.OrderStatus.BS003.getStatus(), Constants.OrderStatus.BS003.getStatus());
            case Constants.Common.FOUR:
                return Collections.singletonList(Constants.OrderStatus.BS007.getStatus());
            case Constants.Common.FIVE:
                return Collections.singletonList(Constants.OrderStatus.BS006.getStatus());
        }
        return null;
    }
}
