package quick.pager.shop.service.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.UserOrderMapper;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.response.OrderResponse;
import quick.pager.shop.model.UserOrder;
import quick.pager.shop.service.common.CommonOrderService;

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

    public Response<List<UserOrder>> userOrder(OrderDTO request) {

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
