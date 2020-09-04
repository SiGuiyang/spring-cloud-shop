package quick.pager.shop.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.param.GoodsCartParam;
import quick.pager.shop.param.GoodsParam;
import quick.pager.shop.param.SettlementParam;
import quick.pager.shop.service.SettlementOrderService;
import quick.pager.shop.constants.IConsts;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.constants.SConsts;
import quick.pager.shop.goods.client.GoodsSkuClient;
import quick.pager.shop.order.client.SellerOrderClient;
import quick.pager.shop.order.client.UserOrderClient;
import quick.pager.shop.order.request.SellerOrderSaveRequest;
import quick.pager.shop.order.request.UserOrderSaveRequest;
import quick.pager.shop.platform.client.SystemConfigDetailClient;
import quick.pager.shop.platform.request.SystemConfigDetailOtherRequest;
import quick.pager.shop.platform.response.SystemConfigDetailResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.settlement.constants.SettlementRedisKeys;

/**
 * SettlementOrderServiceImpl
 *
 * @author siguiyang
 */
@Service
public class SettlementOrderServiceImpl implements SettlementOrderService {

    @Autowired
    private UserOrderClient userOrderClient;
    @Autowired
    private SellerOrderClient sellerOrderClient;
    @Autowired
    private GoodsSkuClient goodsSkuClient;
    @Autowired
    private SystemConfigDetailClient systemConfigDetailClient;
    @Autowired
    private RedisService redisService;

    // TODO 暂时只做简单的校验
    @Override
    public Response<String> check(final SettlementParam param) {
        final List<GoodsCartParam> goodsCart = param.getGoodsCart();
        final Integer integral = param.getIntegral();
        final BigDecimal payAmount = param.getPayAmount();
        final Long userId = param.getUserId();

        // 1. 计算得出商品sku支付总金额
        BigDecimal calPayAmount = goodsCart.stream().map(item -> {
            List<GoodsParam> goods = item.getGoods();
            return goods.stream().map(GoodsParam::getGoodsAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        }).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal deduction = new BigDecimal("100");

        // 2. 积分抵扣金额
        List<SystemConfigDetailResponse> systemConfigDetails = redisService.get(SettlementRedisKeys.INTEGRAL_DEDUCTION);
        if (CollectionUtils.isEmpty(systemConfigDetails)) {
            SystemConfigDetailOtherRequest configDetailOtherReq = new SystemConfigDetailOtherRequest();
            configDetailOtherReq.setConfigKey(SettlementRedisKeys.INTEGRAL_DEDUCTION);
            Response<List<SystemConfigDetailResponse>> configDetailOtherRes = systemConfigDetailClient.queryList(configDetailOtherReq);
            if (ResponseStatus.Code.SUCCESS == configDetailOtherRes.getCode()) {
                systemConfigDetails = configDetailOtherRes.getData();
            }
        }

        if (CollectionUtils.isNotEmpty(systemConfigDetails)) {
            deduction = new BigDecimal(systemConfigDetails.get(IConsts.ZERO).getConfigValue());
        }

        calPayAmount = calPayAmount.add(new BigDecimal(integral).divide(deduction, BigDecimal.ROUND_HALF_DOWN));

        // 3. 校验金额是否相等
        if (IConsts.ZERO != payAmount.compareTo(calPayAmount)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "支付金额与商品计算金额不相等！");
        }

        return new Response<>();
    }

    @Override
    @GlobalTransactional
    public Response<String> createOrder(final SettlementParam param) {
        final List<GoodsCartParam> goodsCart = param.getGoodsCart();
        final Integer integral = param.getIntegral();
        final BigDecimal payAmount = param.getPayAmount();
        final Long userId = param.getUserId();

        // 1. 幂等性验证
        String result = redisService.get(SettlementRedisKeys.APP_SUBMIT_ORDER + userId);

        if (StringUtils.isNotBlank(result)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "请勿重复提交订单");
        }

        // 2. 添加redis锁
        redisService.set(SettlementRedisKeys.APP_SUBMIT_ORDER + userId, SConsts.ONE, 30L);

        // 3. 生产订单做再做二次验证，防止接口攻击

        // 4. 生成用户订单
        UserOrderSaveRequest userOrderSaveReq = new UserOrderSaveRequest();
        userOrderClient.create(userOrderSaveReq);

        // 5. 生成商户订单
        SellerOrderSaveRequest sellerOrderSaveReq = new SellerOrderSaveRequest();

        sellerOrderClient.create(sellerOrderSaveReq);

        // 6. 生成订单商品明细


        return new Response<>();
    }
}
