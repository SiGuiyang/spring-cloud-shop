package quick.pager.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.response.SellerResponse;

/**
 * 商户开户服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SellerSubscribeService implements IService<SellerResponse> {
    @Override
    public Response<SellerResponse> doService(BaseDTO dto) {
        return null;
    }
}
