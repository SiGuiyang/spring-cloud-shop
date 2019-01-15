package quick.pager.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.user.response.SellerResponse;

/**
 * 商户开户服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SellerSubscribeService implements IService<SellerResponse> {
    @Override
    public Response<SellerResponse> doService(DTO dto) {
        return null;
    }
}
