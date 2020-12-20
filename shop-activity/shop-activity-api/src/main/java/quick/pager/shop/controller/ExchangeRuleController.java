package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.service.ExchangeActivityRuleService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

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
    public Response<List<ExchangeActivityRuleResponse>> list(@PathVariable("activityId") Long activityId) {
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

        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);
        return exchangeActivityRuleService.modify(request);
    }

    /**
     * 规则删除
     *
     * @param id         规则主键
     * @param activityId 活动主键
     * @return 规则主键
     */
    @DeleteMapping("/exchange/rule/{id}/{activityId}")
    public Response<Long> modify(@PathVariable("id") Long id, @PathVariable("activityId") Long activityId) {

        return exchangeActivityRuleService.delete(id, activityId);
    }

    /**
     * 设置商品规则
     *
     * @param activityId 换购活动Id
     * @param ruleId     规则Id
     * @param goodsId    商品Id
     */
    @PostMapping("/exchange/goods/rule/{activityId}/{ruleId}/{goodsId}")
    public Response goodsRule(@PathVariable("activityId") Long activityId, @PathVariable("ruleId") Long ruleId, @PathVariable("goodsId") Long goodsId) {
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
