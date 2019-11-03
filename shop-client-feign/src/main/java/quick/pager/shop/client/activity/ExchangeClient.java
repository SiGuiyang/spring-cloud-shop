package quick.pager.shop.client.activity;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.fallback.activity.ExchangeClientFallbackFactory;
import quick.pager.shop.response.ExchangeMemberResponse;
import quick.pager.shop.response.Response;

/**
 * 活动模块
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = ExchangeClientFallbackFactory.class)
public interface ExchangeClient {

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/exchange/{activityId}")
    Response getExchangeActivity(@PathVariable("activityId") Long activityId);

    /**
     * 满赠换购列表
     */
    @RequestMapping(value = "/exchange/list", method = RequestMethod.POST)
    Response list(@RequestBody ExchangeActivityDTO dto);

    /**
     * 添加满赠换购活动
     */
    @RequestMapping(value = "/exchange/create", method = RequestMethod.POST)
    Response create(@RequestBody ExchangeActivityDTO dto);

    /**
     * 添加满赠换购活动
     */
    @RequestMapping(value = "/exchange/modify", method = RequestMethod.PUT)
    Response modify(@RequestBody ExchangeActivityDTO dto);

    /**
     * 活动规则列表
     */
    @RequestMapping(value = "/exchange/rule/list", method = RequestMethod.POST)
    Response ruleList(@RequestBody ExchangeActivityDTO dto);

    /**
     * 活动规则新增
     */
    @RequestMapping(value = "/exchange/rule/create", method = RequestMethod.POST)
    Response createRule(@RequestBody ExchangeActivityDTO dto);

    /**
     * 活动规则修改
     */
    @RequestMapping(value = "/exchange/rule/modify", method = RequestMethod.PUT)
    Response modifyRule(@RequestBody ExchangeActivityDTO dto);

    /**
     * 购买记录
     */
    @RequestMapping(value = "/exchange/purchase/history", method = RequestMethod.POST)
    Response<List<ExchangeMemberResponse>> purchaseHistory(ExchangeActivityDTO dto);

    /**
     * 设置商品规则
     *
     * @param activityId 换购活动Id
     * @param ruleId     规则Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/exchange/goods/rule", method = RequestMethod.PUT)
    Response exchangeGoodsRule(@RequestParam("activityId") Long activityId, @RequestParam("ruleId") Long ruleId, @RequestParam("goodsId") Long goodsId);

    /**
     * 查看换购商品的规则信息
     *
     * @param goodsId 商品Id
     */
    @RequestMapping(value = "/exchange/goods/rule/{activityId}/{goodsId}", method = RequestMethod.GET)
    Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId);
}
