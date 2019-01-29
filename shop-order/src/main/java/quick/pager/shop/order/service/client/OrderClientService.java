package quick.pager.shop.order.service.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.common.response.Response;
import quick.pager.shop.feign.request.OrderRequest;
import quick.pager.shop.feign.response.OrderResponse;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.order.mapper.UserOrderMapper;
import quick.pager.shop.order.service.common.CommonOrderService;

/**
 *
 */
@Service
@Slf4j
public class OrderClientService {

    @Autowired
    private UserOrderMapper userOrderMapper;
    @Autowired
    private CommonOrderService commonOrderService;

    public Response<List<UserOrder>> userOrder(OrderRequest request) {

        PageHelper.startPage(request.getPage(), request.getPageSize());

        List<UserOrder> userOrders = userOrderMapper.selectUserOrders(request.getPhone(), request.getOrderCode(), request.getOrderStatus(),
                request.getOrderType(), request.getBeginTime(), request.getEndTime());

        PageInfo<UserOrder> pageInfo = new PageInfo<>(userOrders);

        Response<List<UserOrder>> response = new Response<>();

        response.setTotal(pageInfo.getTotal());

        response.setData(pageInfo.getList());

        return response;
    }

    /**
     * 用户订单详情
     *
     * @param orderId 订单Id
     */
    public Response<OrderResponse> orderInfo(Long orderId) {
        UserOrder userOrder = userOrderMapper.selectByPrimaryKey(orderId);

        return new Response<>(commonOrderService.transOrder(userOrder));
    }
}
