package quick.pager.shop.service.impl;

import org.springframework.stereotype.Service;
import quick.pager.shop.dto.UserOrderDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Override
    public Response createOrder(UserOrderDTO dto) {

        // TODO 校验客户端计算结果是否与后端一致

        // TODO 计算是否使用优惠券

        // TODO 创建订单

        // TODO 创建商户订单

        // TODO 好友佣金计算，分配奖励，使用异步方式实现

        return null;
    }
}
