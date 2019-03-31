package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;

/**
 * 清结算服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SettlementService implements IService {
    @Override
    public Response doService(BaseDTO dto) {
        return null;
    }
}
