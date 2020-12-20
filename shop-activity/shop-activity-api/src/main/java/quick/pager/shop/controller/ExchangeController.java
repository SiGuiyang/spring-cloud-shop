package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRecordPageRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRecordResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.ExchangeService;
import quick.pager.shop.utils.Assert;


/**
 * 满赠换购
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    /**
     * 购买记录
     */
    @PostMapping("/exchange/record")
    public Response<List<ExchangeActivityRecordResponse>> record(@RequestBody ExchangeActivityRecordPageRequest request) {

        Assert.isTrue(Objects.nonNull(request.getActivityId()), () -> "满赠换购活动不存在");
        return exchangeService.record(request);
    }
}
