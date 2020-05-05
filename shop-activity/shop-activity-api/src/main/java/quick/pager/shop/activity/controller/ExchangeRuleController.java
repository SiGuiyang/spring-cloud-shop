package quick.pager.shop.activity.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.activity.service.ExchangeActivityRuleService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;

/**
 * 满赠换购规则
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class ExchangeRuleController {

    @Autowired
    private ExchangeActivityRuleService exchangeActivityRuleService;

    /**
     * 规则列表
     */
    @GetMapping("/exchange/rule/{activityId}")
    public Response<List<ExchangeActivityRuleResponse>> list(@PathVariable Long activityId) {
        return exchangeActivityRuleService.queryList(activityId);
    }

    /**
     * 规则新增
     */
    @PostMapping("/exchange/rule/create")
    public Response<Long> create(@RequestBody ExchangeActivityRuleSaveRequest request) {
        return exchangeActivityRuleService.create(request);
    }

    /**
     * 规则修改
     */
    @PutMapping("/exchange/rule/modify")
    public Response<Long> modify(@RequestBody ExchangeActivityRuleSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
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

}
