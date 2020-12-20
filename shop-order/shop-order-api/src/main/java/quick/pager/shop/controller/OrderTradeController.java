package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.order.request.OrderTradeSaveRequest;
import quick.pager.shop.service.OrderTradeService;
import quick.pager.shop.user.response.Response;

/**
 * 交易流水
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ORDER)
public class OrderTradeController {


    @Autowired
    private OrderTradeService orderTradeService;

    /**
     * 交易流水新增
     *
     * @param request 请求参数
     * @return 返回数据
     */
    @PostMapping("/trade/create")
    public Response<Long> create(@RequestBody OrderTradeSaveRequest request) {

        return orderTradeService.create(request);
    }
}
