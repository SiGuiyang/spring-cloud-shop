package quick.pager.shop.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.client.ActivityClient;
import quick.pager.shop.client.GoodsClient;
import quick.pager.shop.client.OrderClient;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.RabbitMqKeys;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.InviteFriendAwardDTO;
import quick.pager.shop.dto.OrderDTO;
import quick.pager.shop.dto.UserOrderDTO;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.order.SellerOrder;
import quick.pager.shop.model.order.UserOrder;
import quick.pager.shop.mq.MqMessage;
import quick.pager.shop.mq.MqService;
import quick.pager.shop.response.GoodsResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.CheckOrderService;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.service.UserOrderService;
import quick.pager.shop.utils.DateUtils;

@Service
@Slf4j
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private ActivityClient activityClient;
    @Autowired
    private OrderClient orderClient;
    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private RedisService redisService;

    @Autowired
    private CheckOrderService checkOrderService;
    @Autowired
    private MqService mqService;


    @Override
    public Response orders(OrderDTO dto) {
        return null;
    }

    @Override
    public Response orderInfo(Long orderId) {
        return orderClient.orderInfo(orderId);
    }

    @Override
    @GlobalTransactional
    public Response createOrder(UserOrderDTO dto) {

        String key = RedisKeys.UserKeys.SHOP_ORDER_ + dto.getUserId();

        String value = redisService.get(key);
        try {
            // 幂等性处理
            if (!StringUtils.isEmpty(value)) {
                return new Response(ResponseStatus.Code.FAIL_CODE, "请勿重复下单");
            }

            redisService.set(key, Constants.Common.ONE, 30);

            // TODO 校验配送地址

            // TODO 校验客户端计算下单金额结果是否与后端一致

            List<UserOrderDTO.GoodsCartDTO> goodsCart = dto.getGoodsCart();
            // 初始结算金额
            BigDecimal totalAmount = BigDecimal.ZERO;
            // 商户结算金额
            BigDecimal sellerTotalAmount = BigDecimal.ZERO;
            // 获取购买的商品
            Optional.ofNullable(goodsCart).orElse(Collections.emptyList()).forEach(goodsCartDTO -> {
                Response<GoodsResponse> goodsResponseResponse = goodsClient.goodsInfo(goodsCartDTO.getGoodsId());
                if (ResponseStatus.Code.SUCCESS == goodsResponseResponse.getCode()) {
                    GoodsResponse goodsResponse = goodsResponseResponse.getData();
                    BigDecimal goodsDiscountAmount = goodsResponse.getGoods().getGoodsDiscountAmount();
                }
            });

            // TODO 计算是否使用优惠券
            if (null != dto.getCouponId()) {
                Response<DiscountCoupon> discountCouponResponse = activityClient.userCoupons(dto.getCouponId());
            }
            // TODO 创建订单

            UserOrder userOrder = new UserOrder();
            userOrder.setCouponId(dto.getCouponId());
            userOrder.setShipId(dto.getAddressId());
            userOrder.setUserId(dto.getUserId());
            userOrder.setOrderType(dto.getOrderType());

            Response response = orderClient.userOrderCreate(userOrder);

            // TODO 创建商户订单

            SellerOrder sellerOrder = new SellerOrder();
            sellerOrder.setSellerId(dto.getSellerId());
            sellerOrder.setCreateTime(DateUtils.now());
            sellerOrder.setDeleteStatus(false);


            orderClient.sellerOrderCreate(sellerOrder);


            // 好友佣金计算，分配奖励，使用异步方式实现放在MQ处理
            InviteFriendAwardDTO inviteFriendAwardDTO = new InviteFriendAwardDTO();
            inviteFriendAwardDTO.setUserId(dto.getUserId());
            mqService.sender(MqMessage.builder().queueName(RabbitMqKeys.TOPIC_INVITE_FRIEND_AWARD).payLoad(inviteFriendAwardDTO).build());
        } finally {

            redisService.del(key);
        }
        return new Response();
    }
}
