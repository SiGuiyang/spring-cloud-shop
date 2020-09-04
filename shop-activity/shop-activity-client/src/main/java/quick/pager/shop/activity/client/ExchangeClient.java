package quick.pager.shop.activity.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.activity.request.exchange.ExchangeActivityOtherRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRuleSaveRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.fallback.ExchangeClientFallbackFactory;
import quick.pager.shop.activity.response.ExchangeMemberResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.user.response.Response;

/**
 * 活动模块Client
 *
 * @author siguiyang
 * @version 1.0
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = ExchangeClientFallbackFactory.class)
public interface ExchangeClient {

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     * @return 满赠换购内容
     */
    @GetMapping("/exchange/{activityId}")
    Response<ExchangeActivityResponse> info(@PathVariable("activityId") Long activityId);

    /**
     * 满赠换购列表
     *
     * @param request 请求参数
     * @return 满赠换购列表
     */
    @RequestMapping(value = "/exchange/page", method = RequestMethod.POST)
    Response<List<ExchangeActivityResponse>> queryPage(@RequestBody ExchangeActivityPageRequest request);

    /**
     * 添加满赠换购活动
     *
     * @param request 请求参数
     * @return 满赠换购主键
     */
    @RequestMapping(value = "/exchange/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody ExchangeActivitySaveRequest request);

    /**
     * 添加满赠换购活动
     *
     * @param request 请求参数
     * @return 满赠换购主键
     */
    @RequestMapping(value = "/exchange/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody ExchangeActivitySaveRequest request);

    /**
     * 活动规则列表
     *
     * @param activityId 满赠换购主键
     * @return 满赠换购规则列表
     */
    @RequestMapping(value = "/exchange/rule/{activityId}", method = RequestMethod.GET)
    Response<List<ExchangeActivityRuleResponse>> ruleList(@PathVariable("activityId") Long activityId);

    /**
     * 活动规则新增
     *
     * @param request 请求参数
     * @return 规则主键
     */
    @RequestMapping(value = "/exchange/rule/create", method = RequestMethod.POST)
    Response<Long> createRule(@RequestBody ExchangeActivityRuleSaveRequest request);

    /**
     * 活动规则修改
     *
     * @param request 请求参数
     * @return 规则主键
     */
    @RequestMapping(value = "/exchange/rule/modify", method = RequestMethod.PUT)
    Response<Long> modifyRule(@RequestBody ExchangeActivityRuleSaveRequest request);

    /**
     * 购买记录
     *
     * @param request 请求参数
     * @return 购买记录
     */
    @RequestMapping(value = "/exchange/purchase/history", method = RequestMethod.POST)
    Response<List<ExchangeMemberResponse>> purchaseHistory(@RequestBody ExchangeActivityOtherRequest request);

    /**
     * 设置商品规则
     *
     * @param activityId 换购活动主键
     * @param ruleId     规则主键
     * @param goodsId    商品主键
     * @return 数据响应
     */
    @RequestMapping(value = "/exchange/goods/rule", method = RequestMethod.PUT)
    Response exchangeGoodsRule(@RequestParam("activityId") Long activityId, @RequestParam("ruleId") Long ruleId, @RequestParam("goodsId") Long goodsId);

    /**
     * 查看换购商品的规则信息
     *
     * @param activityId 活动主键
     * @param goodsId    商品主键
     * @return 查看换购商品的规则信息
     */
    @RequestMapping(value = "/exchange/goods/rule/{activityId}/{goodsId}", method = RequestMethod.GET)
    Response goodsRuleInfo(@PathVariable("activityId") Long activityId, @PathVariable("goodsId") Long goodsId);
}
