package quick.pager.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mapper.SellerOrderMapper;
import quick.pager.shop.model.order.SellerOrder;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.SellerOrderService;

@Service
@Slf4j
public class SellerOrderServiceImpl implements SellerOrderService {

    @Autowired
    private SellerOrderMapper sellerOrderMapper;

    @Override
    public Response sellerOrderCreate(SellerOrder sellerOrder) {

        int i = sellerOrderMapper.insertSelective(sellerOrder);

        if (i > 0) {
            return new Response();
        }

        return new Response(ResponseStatus.Code.FAIL_CODE, "创建商户订单失败");
    }
}
