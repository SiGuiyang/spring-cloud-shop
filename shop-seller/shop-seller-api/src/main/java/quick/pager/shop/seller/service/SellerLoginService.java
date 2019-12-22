package quick.pager.shop.seller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.seller.response.SellerResponse;
import quick.pager.shop.service.IService;

/**
 * 商户登陆服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SellerLoginService implements IService<SellerResponse> {
    @Override
    public Response<SellerResponse> doService(BaseDTO dto) {
        return null;
    }
}
