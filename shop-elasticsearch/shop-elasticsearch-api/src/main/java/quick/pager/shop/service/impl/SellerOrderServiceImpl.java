package quick.pager.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.elasticsearch.request.ESSellerOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESSellerOrderResponse;
import quick.pager.shop.repository.SellerOrderRepository;
import quick.pager.shop.service.SellerOrderService;
import quick.pager.shop.user.response.Response;

/**
 * 商户订单es服务实现
 *
 * @author siguiyang
 */
@Service
public class SellerOrderServiceImpl implements SellerOrderService {

    @Autowired
    private SellerOrderRepository sellerOrderRepository;

    @Override
    public Response<List<ESSellerOrderResponse>> queryPage(final ESSellerOrderPageRequest request) {
        return null;
    }
}
