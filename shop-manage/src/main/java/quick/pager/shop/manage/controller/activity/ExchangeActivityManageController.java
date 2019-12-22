package quick.pager.shop.manage.controller.activity;

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

import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.exchange.ExchangeActivityPageParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityRuleSaveParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivitySaveParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.service.activity.ExchangeActivityService;


/**
 * 满赠换购
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class ExchangeActivityManageController {

    @Autowired
    private ExchangeActivityService exchangeActivityService;

    /**
     * 活动列表
     */
    @PostMapping("/activity/exchange/list")
    public Response<List<ExchangeActivityResponse>> list(@RequestBody ExchangeActivityPageParam param) {
        return exchangeActivityService.list(param);
    }

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/activity/exchange/{activityId}")
    public Response<ExchangeActivityResponse> info(@PathVariable("activityId") Long activityId) {
        return exchangeActivityService.info(activityId);
    }

    /**
     * 活动新增
     */
    @PostMapping("/activity/exchange/create")
    public Response<Long> create(@RequestBody ExchangeActivitySaveParam param) {
        return exchangeActivityService.create(param);
    }

    /**
     * 活动修改
     */
    @PutMapping("/activity/exchange/modify")
    public Response<Long> modify(@RequestBody ExchangeActivitySaveParam param) {
        if (Objects.isNull(param.getId())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return exchangeActivityService.modify(param);
    }


    /**
     * 列表
     */
    @GetMapping("/activity/exchange/rule/{activityId}")
    public Response<List<ExchangeActivityRuleResponse>> rules(@PathVariable Long activityId) {
        return exchangeActivityService.rules(activityId);
    }

    /**
     * 规则新增
     */
    @PostMapping("/activity/exchange/rule/create")
    public Response<Long> createRule(@RequestBody ExchangeActivityRuleSaveParam param) {
        return exchangeActivityService.createRule(param);
    }

    /**
     * 规则修改
     */
    @PutMapping("/activity/exchange/rule/modify")
    public Response<Long> modifyRule(@RequestBody ExchangeActivityRuleSaveParam param) {
        return exchangeActivityService.modifyRule(param);
    }

    /**
     * 设置商品规则
     */
    @PutMapping("/activity/exchange/goods/rule")
    public Response goodsRule(@RequestBody ExchangeActivityParam param) {
        return exchangeActivityService.goodsRule(param);
    }

    /**
     * 查看换购商品的规则信息
     *
     * @param goodsId 商品Id
     */
    @GetMapping("/activity/exchange/goods/rule/{activityId}/{goodsId}")
    public Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId) {
        return exchangeActivityService.goodsRuleInfo(activityId, goodsId);
    }

    /**
     * 购买记录
     */
    @PostMapping("/activity/exchange/purchase/history")
    public Response purchaseHistory(@RequestBody ExchangeActivityParam param) {
        return exchangeActivityService.purchaseHistory(param);
    }


}
