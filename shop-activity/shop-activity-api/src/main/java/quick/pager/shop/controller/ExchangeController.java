package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRecordPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRecordResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.service.ExchangeService;


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
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/exchange/{activityId}")
    public Response<ExchangeActivityResponse> info(@PathVariable("activityId") Long activityId) {
        return exchangeService.queryInfo(activityId);
    }

    /**
     * 活动列表
     */
    @PostMapping("/exchange/page")
    public Response<List<ExchangeActivityResponse>> queryPage(@RequestBody ExchangeActivityPageRequest request) {
        return exchangeService.queryPage(request);
    }

    /**
     * 活动新增
     */
    @PostMapping("/exchange/create")
    public Response<Long> create(@RequestBody ExchangeActivitySaveRequest request) {
        return exchangeService.create(request);
    }

    /**
     * 活动修改
     */
    @PutMapping("/exchange/modify")
    public Response<Long> modify(@RequestBody ExchangeActivitySaveRequest request) {
        return exchangeService.modify(request);
    }

    /**
     * 购买记录
     */
    @PostMapping("/exchange/record")
    public Response<List<ExchangeActivityRecordResponse>> record(@RequestBody ExchangeActivityRecordPageRequest request) {

        if (Objects.isNull(request.getActivityId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "满赠换购活动不存在");
        }
        return exchangeService.record(request);
    }
}
