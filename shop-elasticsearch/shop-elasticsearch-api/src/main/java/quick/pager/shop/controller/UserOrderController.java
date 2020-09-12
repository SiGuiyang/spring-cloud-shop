package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.elasticsearch.request.ESUserOrderPageRequest;
import quick.pager.shop.elasticsearch.response.ESUserOrderResponse;
import quick.pager.shop.service.UserOrderService;
import quick.pager.shop.user.response.Response;

/**
 * 用户订单ES服务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ELASTICSEARCH)
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    /**
     * 订单查询
     *
     * @param request 请求参数
     */
    @PostMapping("/user/order/page")
    public Response<List<ESUserOrderResponse>> queryPage(@RequestBody final ESUserOrderPageRequest request) {

        return userOrderService.queryPage(request);
    }
}
