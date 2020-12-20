package quick.pager.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.seata.spring.annotation.GlobalTransactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.client.DiscountCouponClient;
import quick.pager.shop.activity.response.coupon.DiscountCouponResponse;
import quick.pager.shop.cart.client.CartClient;
import quick.pager.shop.cart.client.OrderCartClient;
import quick.pager.shop.cart.request.CartOtherRequest;
import quick.pager.shop.cart.request.OrderCartRequest;
import quick.pager.shop.cart.request.OrderCartSaveRequest;
import quick.pager.shop.cart.response.GoodsCartResponse;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.SConsts;
import quick.pager.shop.constants.SettlementConstants;
import quick.pager.shop.goods.client.GoodsSkuClient;
import quick.pager.shop.goods.response.sku.GoodsSkuResponse;
import quick.pager.shop.order.client.OrderTradeClient;
import quick.pager.shop.order.enums.OrderStatusEnums;
import quick.pager.shop.order.enums.OrderTypeEnums;
import quick.pager.shop.order.enums.PayTypeEnums;
import quick.pager.shop.order.enums.TradeTypeEnums;
import quick.pager.shop.order.request.OrderTradeSaveRequest;
import quick.pager.shop.platform.dto.SystemConfigDTO;
import quick.pager.shop.service.SettlementOrderService;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.order.client.SellerOrderClient;
import quick.pager.shop.order.client.UserOrderClient;
import quick.pager.shop.order.request.SellerOrderSaveRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.settlement.dto.DiscountCouponDTO;
import quick.pager.shop.settlement.dto.SettlementDeliveryTimeDTO;
import quick.pager.shop.settlement.dto.SettlementPayTypeDTO;
import quick.pager.shop.settlement.dto.SettlementSkuDTO;
import quick.pager.shop.settlement.request.SettlementCheckRequest;
import quick.pager.shop.settlement.request.SettlementRequest;
import quick.pager.shop.settlement.request.SettlementSkuRequest;
import quick.pager.shop.settlement.request.SettlementSubmitRequest;
import quick.pager.shop.settlement.dto.SettlementAddrDTO;
import quick.pager.shop.settlement.response.SettlementSkuResponse;
import quick.pager.shop.user.client.AddressClient;
import quick.pager.shop.user.client.UserAccountClient;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.settlement.constants.SettlementRedisKeys;
import quick.pager.shop.user.response.UserAccountResponse;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

/**
 * SettlementOrderServiceImpl
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class SettlementOrderServiceImpl implements SettlementOrderService {


    @Autowired
    private DiscountCouponClient discountCouponClient;
    @Autowired
    private UserOrderClient userOrderClient;
    @Autowired
    private SellerOrderClient sellerOrderClient;
    @Autowired
    private CartClient cartClient;
    @Autowired
    private OrderCartClient orderCartClient;
    @Autowired
    private OrderTradeClient orderTradeClient;
    @Autowired
    private AddressClient addressClient;
    @Autowired
    private UserAccountClient userAccountClient;
    @Autowired
    private GoodsSkuClient goodsSkuClient;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Value(("${spring.profiles.active}"))
    private String env;

    @Override
    public Response<SettlementSkuResponse> check(final SettlementCheckRequest request) {
        final Long userId = request.getUserId();
        final List<Long> goodsCartIds = request.getGoodsCartIds();
        final BigDecimal settlementAmount = request.getSettlementAmount();
        CartOtherRequest cartOtherReq = new CartOtherRequest();
        cartOtherReq.setGoodsCartIds(goodsCartIds);
        Response<List<GoodsCartResponse>> cartOtherRes = cartClient.list(cartOtherReq);
        if (!cartOtherRes.check()) {
            return Response.toError(cartOtherRes.getCode(), cartOtherRes.getMsg());
        }

        List<GoodsCartResponse> cartOtherResData = cartOtherRes.getData();
        cartOtherResData.stream().map(item -> item.getDiscountAmount().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal::add).ifPresent(amount ->
                Assert.isTrue(amount.compareTo(settlementAmount) == 0, () -> "结算金额与清结算金额不一致"));

        // 组装数据，并返回
        SettlementSkuResponse settlementSkuRes = new SettlementSkuResponse();

        // 1. 组装配送地址
        Response<AddressResponse> addressRes = addressClient.address(userId);
        AddressResponse addressResData = addressRes.getData();
        if (addressRes.check() && Objects.nonNull(addressResData)) {

            SettlementAddrDTO addr = new SettlementAddrDTO();
            addr.setId(addressResData.getId());
            addr.setAddrName(addressResData.getDeliveryAddress().concat(addressResData.getHouseNumber()));
            addr.setDefaultAddress(addressResData.getDefaultAddress());
            addr.setLabel(addressResData.getLabel());

            settlementSkuRes.setAddr(addr);
        }

        // 2. 设置配送时间
        settlementSkuRes.setDeliveryTime(this.getDeliveryTime());
        // 3. 购买商品
        settlementSkuRes.setSkus(this.doSkus(cartOtherResData));
        // 4. 支付方式
        settlementSkuRes.setPayTypes(this.doPayType());
        // 5. 优惠券
        settlementSkuRes.setCoupons(this.doDiscountCoupon(userId));
        // 6. 商品总金额
        BigDecimal orderAmount = cartOtherResData.stream().map(GoodsCartResponse::getDiscountAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        settlementSkuRes.setOrderAmount(orderAmount);
        // 7. 配送费
        BigDecimal deliveryAmount = this.getDeliveryAmount();
        settlementSkuRes.setDeliveryAmount(deliveryAmount);
        // 8. 是否免配送费
        settlementSkuRes.setFreeDeliveryAmount(this.getFreeDeliveryAmount(orderAmount));
        // 9. 用户积分
        settlementSkuRes.setIntegral(this.getIntegral(userId));

        return Response.toResponse(settlementSkuRes);
    }

    @Override
    @GlobalTransactional
    public Response<Long> createOrder(final SettlementRequest request) {
        final Long userId = request.getUserId();
        final Long sellerId = request.getSellerId();
        final List<SettlementSkuRequest> skus = request.getSkus();
        final Integer integral = request.getIntegral();

        // 1. 幂等性验证
        RLock lock = redissonClient.getLock(env.concat(SettlementRedisKeys.APP_SUBMIT_ORDER) + userId);

        // 用户订单主键
        Long userOrderId = null;
        // 商户订单主键
        Long sellerOrderId;
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                // 2. 生成用户订单
                UserOrderSaveRequest userOrderSaveReq = new UserOrderSaveRequest();
                userOrderSaveReq.setAddrId(request.getAddrId());
                userOrderSaveReq.setCouponId(request.getCouponId());
                userOrderSaveReq.setOrderStatus(OrderStatusEnums.BS001);
                userOrderSaveReq.setOrderType(OrderTypeEnums.parse(request.getOrderType()));
                userOrderSaveReq.setPayType(PayTypeEnums.parse(request.getPayType()));
                userOrderSaveReq.setDeliveryTime(request.getDeliveryTime());
                userOrderSaveReq.setIntegral(integral);
                userOrderSaveReq.setIntegralAmount(Objects.nonNull(integral) ? BigDecimal.valueOf(integral).divide(BigDecimal.valueOf(100), 2) : BigDecimal.ZERO);
                userOrderSaveReq.setOrderAmount(request.getOrderAmount());
                userOrderSaveReq.setDiscountAmount(request.getDiscountAmount());
                userOrderSaveReq.setPayAmount(request.getPayAmount());
                userOrderSaveReq.setSelf(request.getSelf());

                Response<Long> userOrderSaveRes = userOrderClient.create(userOrderSaveReq);
                if (!userOrderSaveRes.check()) {
                    log.error("创建订单失败 userId = {}, sellerId = {}", userId, sellerId);
                    return Response.toError(ResponseStatus.Code.FAIL_CODE, "创建订单失败");
                }
                userOrderId = userOrderSaveRes.getData();

                // 3. 生成商户订单
                SellerOrderSaveRequest sellerOrderSaveReq = new SellerOrderSaveRequest();

                sellerOrderSaveReq.setAddrId(request.getAddrId());
                sellerOrderSaveReq.setUserId(userId);
                sellerOrderSaveReq.setSellerId(sellerId);
                sellerOrderSaveReq.setPayType(PayTypeEnums.parse(request.getPayType()));
                sellerOrderSaveReq.setOrderStatus(OrderStatusEnums.BS001);
                sellerOrderSaveReq.setOrderType(OrderTypeEnums.parse(request.getOrderType()));
                sellerOrderSaveReq.setDeliveryTime(request.getDeliveryTime());
                sellerOrderSaveReq.setOrderAmount(request.getOrderAmount());
                sellerOrderSaveReq.setSelf(request.getSelf());

                Response<Long> sellerOrderSaveRes = sellerOrderClient.create(sellerOrderSaveReq);
                if (!sellerOrderSaveRes.check()) {
                    log.error("创建商户订单失败 userId = {}, sellerId = {}", userId, sellerId);
                    return Response.toError(ResponseStatus.Code.FAIL_CODE, "创建订单失败");
                }

                sellerOrderId = sellerOrderSaveRes.getData();

                // 4. 订单中商品
                OrderCartSaveRequest orderCartSaveReq = new OrderCartSaveRequest();
                orderCartSaveReq.setUserId(userId);
                orderCartSaveReq.setSellerId(sellerId);
                orderCartSaveReq.setUserOrderId(userOrderId);
                orderCartSaveReq.setSellerOrderId(sellerOrderId);

                // 组装订单商品购物车数据
                orderCartSaveReq.setOrderCarts(skus.stream().map(sku -> {
                    OrderCartRequest orderCartReq = new OrderCartRequest();
                    Long skuId = sku.getSkuId();
                    orderCartReq.setSkuId(skuId);
                    orderCartReq.setQuantity(sku.getQuantity());
                    Response<GoodsSkuResponse> goodsSkuRes = goodsSkuClient.querySku(skuId, null);
                    if (!goodsSkuRes.check()) {
                        GoodsSkuResponse skuData = goodsSkuRes.getData();
                        orderCartReq.setDiscountAmount(skuData.getDiscountAmount());
                        orderCartReq.setSkuAmount(skuData.getSkuAmount());
                    }
                    return orderCartReq;
                }).collect(Collectors.toList()));

                Response<List<GoodsCartResponse>> orderCartSaveRes = orderCartClient.create(orderCartSaveReq);
                if (!orderCartSaveRes.check()) {
                    log.error("创建订单购物车订单失败 userId = {}, sellerId = {}", userId, sellerId);
                    return Response.toError(ResponseStatus.Code.FAIL_CODE, "创建订单失败");
                }

            } else {
                return Response.toError(ResponseStatus.Code.FAIL_CODE, "订单正在处理中，请勿重复提交");
            }
        } catch (Exception e) {
            log.error("创建订单失败，失败结果 result = {}", e.getMessage());
        } finally {
            if (Objects.nonNull(lock) && lock.isLocked()) {
                lock.unlock();
            }
        }
        return Response.toResponse(userOrderId);
    }

    @Override
    public Response<Long> submit(final SettlementSubmitRequest request) {

        OrderTradeSaveRequest orderTradeSaveReq = new OrderTradeSaveRequest();
        orderTradeSaveReq.setPayType(PayTypeEnums.parse(request.getPayType()));
        orderTradeSaveReq.setTradeType(TradeTypeEnums.parse(request.getTradeType()));
        orderTradeSaveReq.setUserId(request.getUserId());
        orderTradeSaveReq.setOutTradeNo(request.getOutTradeNo());
        orderTradeSaveReq.setTradeNo(request.getTradeNo());
        orderTradeSaveReq.setTotalAmount(request.getTotalAmount());
        Response<Long> orderTradeSaveRes = orderTradeClient.create(orderTradeSaveReq);

        if (!orderTradeSaveRes.check()) {
            log.error("创建交易流水号失败");
            return Response.toError(orderTradeSaveRes.getCode(), orderTradeSaveRes.getMsg());
        }

        return Response.toResponse(orderTradeSaveRes.getData());
    }


    /**
     * 处理配送时间
     *
     * @return 配送时间
     */
    private List<SettlementDeliveryTimeDTO> getDeliveryTime() {

        Long size = redisTemplate.opsForList().size(SettlementConstants.REDIS_DELIVERY_TIME);

        // 缓存中获取配送时间
        if (Objects.nonNull(size)) {
            List<Object> result = redisTemplate.opsForList().range(SettlementConstants.REDIS_DELIVERY_TIME, 0, size);

            List<SystemConfigDTO> deliveryTimeDTOS = JSON.parseArray(JSON.toJSONString(result), SystemConfigDTO.class);

            LocalDateTime now = DateUtils.dateTime();
            String today = DateUtils.format(now, DateUtils.PURE_MINUTES_PATTERN);

            int pos = 0;
            for (SystemConfigDTO dto : deliveryTimeDTOS) {
                pos++;
                String[] split = dto.getConfigValue().split(SConsts.SHOULDER);
                LocalDateTime start = DateUtils.parseTime(today.concat(":").concat(split[0].trim()));
                LocalDateTime end = DateUtils.parseTime(today.concat(":").concat(split[1].trim()));
                if (now.isBefore(start) && DateUtils.plusMinutes(now, 30).isBefore(end)) {
                    break;
                }
            }
            return Lists.newArrayList(
                    SettlementDeliveryTimeDTO.builder()
                            .deliveryTime(deliveryTimeDTOS.stream().skip(pos).map(SystemConfigDTO::getConfigValue).collect(Collectors.toList()))
                            .name("今天")
                            .build(),
                    SettlementDeliveryTimeDTO.builder()
                            .deliveryTime(deliveryTimeDTOS.stream().map(SystemConfigDTO::getConfigValue).collect(Collectors.toList()))
                            .name("明天")
                            .build()
            );
        }
        return Lists.newArrayList();
    }

    /**
     * 转换购买商品
     *
     * @param cartOtherResData 订单购物车商品
     * @return 购买商品
     */
    private List<SettlementSkuDTO> doSkus(final List<GoodsCartResponse> cartOtherResData) {
        return cartOtherResData.stream().map(item -> {
            SettlementSkuDTO skuDTO = new SettlementSkuDTO();
            skuDTO.setSkuId(item.getSkuId());
            skuDTO.setSkuName(item.getSkuName());
            skuDTO.setSkuImage(item.getSkuImage());
            skuDTO.setSkuAmount(item.getSkuAmount());
            skuDTO.setDiscountAmount(item.getDiscountAmount());
            skuDTO.setQuantity(item.getQuantity());
            return skuDTO;
        }).collect(Collectors.toList());
    }

    /**
     * 支付方式
     */
    private List<SettlementPayTypeDTO> doPayType() {
        return Stream.of(PayTypeEnums.values()).map(item -> {
            SettlementPayTypeDTO payTypeDTO = new SettlementPayTypeDTO();
            payTypeDTO.setPayType(item.getCode());
            payTypeDTO.setName(item.getDesc());
            return payTypeDTO;
        }).collect(Collectors.toList());
    }

    /**
     * 优惠券
     *
     * @param userId 用户主键
     * @return 优惠券列表
     */
    private List<DiscountCouponDTO> doDiscountCoupon(final Long userId) {

        Response<List<DiscountCouponResponse>> response = discountCouponClient.list(userId);

        List<DiscountCouponResponse> discountCouponData = response.getData();
        if (response.check() && Objects.nonNull(discountCouponData)) {
            return discountCouponData.stream().map(item -> {
                DiscountCouponDTO dto = new DiscountCouponDTO();
                dto.setBeginTime(item.getBeginTime());
                dto.setEndTime(item.getEndTime());
                dto.setDescription(item.getDescription());
                dto.setDiscountStrength(item.getDiscountStrength());
                dto.setTemplateId(item.getTemplateId());
                dto.setTemplateName(item.getTemplateName());
                dto.setTemplateType(item.getTemplateType());
                dto.setDiscountAmount(item.getDiscountAmount());
                dto.setOrderAmount(item.getOrderAmount());
                dto.setPhone(item.getPhone());
                return dto;
            }).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 获取配送费
     */
    private BigDecimal getDeliveryAmount() {
        Long size = redisTemplate.opsForList().size(SettlementConstants.REDIS_DELIVERY_AMOUNT);

        if (Objects.nonNull(size)) {
            List<Object> result = redisTemplate.opsForList().range(SettlementConstants.REDIS_DELIVERY_AMOUNT, IConsts.ZERO, size);
            List<SystemConfigDTO> configDTOS = JSON.parseArray(JSON.toJSONString(result), SystemConfigDTO.class);
            return new BigDecimal(configDTOS.get(IConsts.ZERO).getConfigValue());
        }

        return new BigDecimal("5.00");
    }

    /**
     * 获取免配送费金额
     *
     * @param orderAmount 订单金额
     * @return 免配送费金额
     */
    private BigDecimal getFreeDeliveryAmount(final BigDecimal orderAmount) {

        Long size = redisTemplate.opsForList().size(SettlementConstants.REDIS_FREE_DELIVERY_ORDER_AMOUNT);

        if (Objects.nonNull(size)) {
            List<Object> result = redisTemplate.opsForList().range(SettlementConstants.REDIS_FREE_DELIVERY_ORDER_AMOUNT, IConsts.ZERO, size);
            List<SystemConfigDTO> configDTOS = JSON.parseArray(JSON.toJSONString(result), SystemConfigDTO.class);
            BigDecimal freeDeliveryOrderAmount = new BigDecimal(configDTOS.get(IConsts.ZERO).getConfigValue());

            if (orderAmount.compareTo(freeDeliveryOrderAmount) >= IConsts.ZERO) {
                return new BigDecimal("5.00");
            }
        }
        return new BigDecimal("0.00");
    }

    /**
     * 获取用户积分
     *
     * @param userId 用户主键
     */
    private Integer getIntegral(final Long userId) {
        Response<UserAccountResponse> response = userAccountClient.account(userId);

        if (response.check() && Objects.nonNull(response.getData())) {
            return response.getData().getIntegral();
        }

        return IConsts.ZERO;
    }
}
