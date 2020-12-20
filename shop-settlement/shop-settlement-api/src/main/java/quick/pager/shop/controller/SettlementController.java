package quick.pager.shop.controller;

import java.math.BigDecimal;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.service.SettlementOrderService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.settlement.request.SettlementCheckRequest;
import quick.pager.shop.settlement.request.SettlementRequest;
import quick.pager.shop.settlement.request.SettlementSubmitRequest;
import quick.pager.shop.settlement.response.SettlementSkuResponse;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 清结算生成订单
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.SETTLEMENT)
public class SettlementController {

    @Autowired
    private SettlementOrderService settlementOrderService;

    /**
     * 验证结算数据是否正确，并返回支付订单详情页
     *
     * @param request 请求参数
     * @return 返回响应消息
     */
    @PostMapping("check")
    public Response<SettlementSkuResponse> check(@RequestBody SettlementCheckRequest request) {

        Assert.isTrue(Objects.nonNull(request.getSettlementAmount()), () -> "清结算结算金额不能为空");
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getGoodsCartIds()), () -> "清结算商品购物车不能为空");

        return settlementOrderService.check(request);
    }

    /**
     * 生成订单
     *
     * @param request 请求参数
     * @return 返回响应消息
     */
    @PostMapping("create")
    public Response<Long> create(@RequestBody SettlementRequest request) {

        Assert.isTrue(CollectionUtils.isNotEmpty(request.getSkus()), () -> "购买商品不存在");
        Assert.isTrue(Objects.nonNull(request.getAddrId()), () -> "配送地址为空");
        Assert.isTrue(StringUtils.isNotEmpty(request.getDeliveryTime()), () -> "配送时间为空");
        Assert.isTrue(Objects.nonNull(request.getPayType()), () -> "支付方式不能为空");
        Assert.isTrue(Objects.nonNull(request.getIntegral()) && BigDecimal.valueOf(request.getIntegral()).compareTo(BigDecimal.valueOf(100)) < 0, () -> "积分金额使用错误");

        return settlementOrderService.createOrder(request);
    }

    /**
     * 支付成功后主动调用
     * 更新订单状态并记录三方支付的订单号
     *
     * @param request 请求参数
     */
    @PostMapping("submit")
    public Response<Long> submit(@RequestBody SettlementSubmitRequest request) {

        Assert.isTrue(StringUtils.isNotEmpty(request.getOutTradeNo()), () -> "交易流水号为空");
        Assert.isTrue(StringUtils.isNotEmpty(request.getTradeNo()), () -> "第三方支付交易流水号为空");
        Assert.isTrue(Objects.nonNull(request.getTotalAmount()), () -> "支付总金额为空");

        return settlementOrderService.submit(request);
    }
}
