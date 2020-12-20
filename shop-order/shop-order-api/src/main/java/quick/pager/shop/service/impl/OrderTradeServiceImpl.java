package quick.pager.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.mapper.OrderTradeMapper;
import quick.pager.shop.model.OrderTrade;
import quick.pager.shop.order.request.OrderTradeSaveRequest;
import quick.pager.shop.service.OrderTradeService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.DateUtils;

@Service
public class OrderTradeServiceImpl implements OrderTradeService {

    @Autowired
    private OrderTradeMapper orderTradeMapper;

    @Override
    public Response<Long> create(final OrderTradeSaveRequest request) {

        OrderTrade orderTrade = new OrderTrade();
        orderTrade.setUserId(request.getUserId());
        orderTrade.setOutTradeNo(request.getOutTradeNo());
        orderTrade.setTradeNo(request.getTradeNo());
        orderTrade.setPayType(request.getPayType().getCode());
        orderTrade.setTradeType(request.getTradeType().getCode());
        orderTrade.setTotalAmount(request.getTotalAmount());
        orderTrade.setCreateTime(DateUtils.dateTime());
        orderTrade.setUpdateTime(DateUtils.dateTime());
        orderTrade.setDeleteStatus(Boolean.FALSE);
        orderTradeMapper.insert(orderTrade);
        return Response.toResponse(orderTrade.getId());
    }
}
