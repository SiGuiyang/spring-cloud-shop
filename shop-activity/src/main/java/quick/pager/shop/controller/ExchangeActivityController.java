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
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.ExchangeActivityHistoryService;
import quick.pager.shop.service.ExchangeActivityRuleService;
import quick.pager.shop.service.ExchangeActivityService;


/**
 * 满赠换购
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.ACTIVITY)
public class ExchangeActivityController {

    @Autowired
    private ExchangeActivityService exchangeActivityService;
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
        ExchangeActivityDTO dto = new ExchangeActivityDTO();
        dto.setActivityId(activityId);
        dto.setEvent(Constants.Event.INFO);
        return exchangeActivityService.doService(dto);
    }

    /**
     * 活动列表
     */
    @PostMapping("/exchange/list")
    public Response getExchangeActivitys(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return exchangeActivityService.doService(dto);
    }

    /**
     * 活动新增
     */
    @PostMapping(value = "/exchange")
    public Response addExchangeActivitys(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.ADD);
        return exchangeActivityService.doService(dto);
    }

    /**
     * 活动修改
     */
    @PutMapping(value = "/exchange")
    public Response modifyExchangeActivitys(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.MODIFY);
        return exchangeActivityService.doService(dto);
    }

    /**
     * 规则列表
     */
    @PostMapping(value = "/exchange/rule/list")
    public Response getExchangeActivityRules(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.LIST);
        return exchangeActivityRuleService.doService(dto);
    }

    /**
     * 规则新增
     */
    @PostMapping(value = "/exchange/rule")
    public Response addExchangeActivityRules(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.ADD);
        return exchangeActivityRuleService.doService(dto);
    }

    /**
     * 规则修改
     */
    @PutMapping(value = "/exchange/rule")
    public Response modifyExchangeActivityRules(@RequestBody ExchangeActivityDTO dto) {
        dto.setEvent(Constants.Event.MODIFY);
        return exchangeActivityRuleService.doService(dto);
    }

    /**
     * 设置商品规则
     *
     * @param activityId 换购活动Id
     * @param ruleId     规则Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/exchange/goods/rule", method = RequestMethod.PUT)
    public Response exchangeGoodsRule(@RequestParam("activityId") Long activityId, @RequestParam("ruleId") Long ruleId, @RequestParam("goodsId") Long goodsId) {

        ExchangeActivityDTO dto = new ExchangeActivityDTO();
        dto.setActivityId(activityId);
        dto.setRuleId(ruleId);
        dto.setGoodsId(goodsId);
        dto.setEvent("exchangeRule");

        return exchangeActivityRuleService.doService(dto);
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

        return exchangeActivityRuleService.doService(dto);
    }

    /**
     * 购买记录
     */
    @PostMapping("/exchange/purchase/history")
    public Response purchaseHistory(@RequestBody ExchangeActivityDTO dto) {
        return exchangeActivityHistoryService.doService(dto);
    }
}
