package quick.pager.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.elasticsearch.client.ESSellerOrderClient;
import quick.pager.shop.mapper.SellerOrderMapper;
import quick.pager.shop.order.request.SellerOrderSaveRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.SellerOrderService;

@Service
public class SellerOrderServiceImpl implements SellerOrderService {

    @Autowired
    private ESSellerOrderClient esSellerOrderClient;
    @Autowired
    private SellerOrderMapper sellerOrderMapper;
    @Override
    public Response create(SellerOrderSaveRequest request) {
        return null;
    }
}
