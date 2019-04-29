package quick.pager.shop.service;

import quick.pager.shop.dto.UserOrderDTO;
import quick.pager.shop.response.Response;

public interface UserOrderService {

    /**
     * 下单
     */
    Response createOrder(UserOrderDTO dto);
}
