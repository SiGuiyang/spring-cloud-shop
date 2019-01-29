package quick.pager.shop.seller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.BaseDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.seller.response.SellerResponse;

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
