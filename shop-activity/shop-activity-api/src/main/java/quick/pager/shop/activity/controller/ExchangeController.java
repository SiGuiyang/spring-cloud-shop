package quick.pager.shop.activity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.param.exchange.ExchangeActivityParam;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.ExchangeActivityHistoryService;
import quick.pager.shop.activity.service.ExchangeActivityRuleService;
import quick.pager.shop.activity.service.ExchangeService;


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
    @Autowired
    private ExchangeActivityRuleService exchangeActivityRuleService;
    @Autowired
    private ExchangeActivityHistoryService exchangeActivityHistoryService;

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/exchange/{activityId}")
    public Response<ExchangeActivityResponse> info(@PathVariable("activityId") Long activityId) {
        return exchangeService.exchangeInfo(activityId);
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
     * 规则列表
     */
    @GetMapping("/exchange/rule/{activityId}")
    public Response<List<ExchangeActivityRuleResponse>> ruleList(@PathVariable Long activityId) {
        return exchangeActivityRuleService.queryList(activityId);
    }

    /**
     * 规则新增
     */
    @PostMapping("/exchange/rule/create")
    public Response createRule(@RequestBody ExchangeActivityRuleSaveRequest request) {
        return exchangeActivityRuleService.create(request);
    }

    /**
     * 规则修改
     */
    @PutMapping("/exchange/rule/modify")
    public Response modifyRule(@RequestBody ExchangeActivityRuleSaveRequest request) {
        return exchangeActivityRuleService.modify(request);
    }

    /**
     * 设置商品规则
     *
     * @param activityId 换购活动Id
     * @param ruleId     规则Id
     * @param goodsId    商品Id
     */
    @PutMapping("/exchange/goods/rule")
    public Response goodsRule(@RequestParam("activityId") Long activityId, @RequestParam("ruleId") Long ruleId, @RequestParam("goodsId") Long goodsId) {
        return null;
    }

    /**
     * 查看换购商品的规则信息
     *
     * @param goodsId 商品Id
     */
    @GetMapping("/exchange/goods/rule/{activityId}/{goodsId}")
    public Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId) {

        return null;
    }

    /**
     * 购买记录
     */
    @PostMapping("/exchange/purchase/history")
    public Response purchaseHistory(@RequestBody ExchangeActivityParam param) {
        return null;
    }
}
