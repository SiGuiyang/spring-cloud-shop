package quick.pager.shop.controller;

import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.param.SettlementParam;
import quick.pager.shop.service.SettlementOrderService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;

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
     * 验证结算数据是否正确
     *
     * @param param 请求参数
     * @return 返回响应消息
     */
    @PostMapping("check")
    public Response<String> check(@RequestBody SettlementParam param) {
        if (Objects.isNull(param.getShipId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "请先完善配送地址");
        }
        if (CollectionUtils.isEmpty(param.getGoodsCart())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.TELNET_EXCEPTION);
        }
        return settlementOrderService.check(param);
    }

    /**
     * 生成订单
     *
     * @param param 请求参数
     * @return 返回响应消息
     */
    @PostMapping("create")
    public Response<String> create(@RequestBody SettlementParam param) {
        if (CollectionUtils.isEmpty(param.getGoodsCart())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.TELNET_EXCEPTION);
        }
        return settlementOrderService.createOrder(param);
    }
}
