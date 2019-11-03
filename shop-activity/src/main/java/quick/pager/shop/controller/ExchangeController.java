package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.ExchangeActivityHistoryService;
import quick.pager.shop.service.ExchangeActivityRuleService;
import quick.pager.shop.service.ExchangeService;


/**
 * 满赠换购
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
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
    public Response getExchangeActivity(@PathVariable("activityId") Long activityId) {
        return exchangeService.exchangeInfo(activityId);
    }

    /**
     * 活动列表
     */
    @PostMapping("/exchange/list")
    public Response list(@RequestBody ExchangeActivityDTO dto) {
        return exchangeService.exchangeActivityList(dto);
    }

    /**
     * 活动新增
     */
    @PostMapping(value = "/exchange/create")
    public Response create(@RequestBody ExchangeActivityDTO dto) {
        return exchangeService.createOrModifyExchange(dto);
    }

    /**
     * 活动修改
     */
    @PutMapping(value = "/exchange/modify")
    public Response modify(@RequestBody ExchangeActivityDTO dto) {
        return exchangeService.createOrModifyExchange(dto);
    }

    /**
     * 规则列表
     */
    @PostMapping(value = "/exchange/rule/list")
    public Response ruleList(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityRuleService.rules(dto.getActivityId());
    }

    /**
     * 规则新增
     */
    @PostMapping(value = "/exchange/rule/create")
    public Response createRule(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityRuleService.createOrModifyRule(dto);
    }

    /**
     * 规则修改
     */
    @PutMapping(value = "/exchange/rule/modify")
    public Response modifyRule(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.MODIFY);
        return exchangeActivityRuleService.createOrModifyRule(dto);
    }

    /**
     * 设置商品规则
     *
     * @param activityId 换购活动Id
     * @param ruleId     规则Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/exchange/goods/rule", method = RequestMethod.PUT)
    public Response goodsRule(@RequestParam("activityId") Long activityId, @RequestParam("ruleId") Long ruleId, @RequestParam("goodsId") Long goodsId) {

        ExchangeActivityDTO dto = new ExchangeActivityDTO();
        dto.setActivityId(activityId);
        dto.setRuleId(ruleId);
        dto.setGoodsId(goodsId);
        dto.setEvent("exchangeRule");

        return null;
//        return exchangeActivityRuleService.doService(dto);
    }

    /**
     * 查看换购商品的规则信息
     *
     * @param goodsId 商品Id
     */
    @RequestMapping(value = "/exchange/goods/rule/{activityId}/{goodsId}", method = RequestMethod.GET)
    public Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId) {
        ExchangeActivityDTO dto = new ExchangeActivityDTO();
        dto.setGoodsId(goodsId);
        dto.setActivityId(activityId);
        dto.setEvent("exchangeGoodsRuleInfo");

        return null;
//        return exchangeActivityRuleService.doService(dto);
    }

    /**
     * 购买记录
     */
    @PostMapping("/exchange/purchase/history")
    public Response purchaseHistory(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityHistoryService.doService(dto);
    }
}
