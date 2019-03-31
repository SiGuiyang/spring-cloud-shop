package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.response.OrderResponse;

/**
 * 订单详情
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class OrderDetailService implements IService<OrderResponse> {
    @Override
    public Response<OrderResponse> doService(BaseDTO dto) {
        return null;
    }
}
