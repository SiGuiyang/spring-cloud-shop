package quick.pager.shop.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.feign.response.OrderResponse;

/**
 * 订单详情
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class OrderDetailService implements IService<OrderResponse> {
    @Override
    public Response<OrderResponse> doService(DTO dto) {
        return null;
    }
}
