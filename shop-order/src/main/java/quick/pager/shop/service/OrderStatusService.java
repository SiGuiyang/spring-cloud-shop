package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * 订单状态图
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class OrderStatusService implements IService {
    @Override
    public Response doService(BaseDTO dto) {
        return null;
    }
}
