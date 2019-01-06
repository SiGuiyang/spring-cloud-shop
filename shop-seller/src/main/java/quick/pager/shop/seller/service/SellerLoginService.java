package quick.pager.shop.seller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.seller.response.SellerResponse;

/**
 * 商户登陆服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SellerLoginService implements IService<SellerResponse> {
    @Override
    public Response<SellerResponse> doService(DTO dto) {
        return null;
    }
}
