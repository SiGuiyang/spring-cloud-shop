package quick.pager.shop.client.activity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.ConstantsClient;
import quick.pager.shop.dto.activity.AssembleDTO;
import quick.pager.shop.fallback.activity.FightGroupClientFallbackFactory;
import quick.pager.shop.response.Response;

/**
 * 拼团活动
 *
 * @author siguiyang
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = FightGroupClientFallbackFactory.class)
public interface AssembleClient {

    /**
     * 拼团活动列表
     */
    @RequestMapping(value = "/assemble/list", method = RequestMethod.POST)
    Response list(@RequestBody AssembleDTO dto);

    /**
     * 拼团活动新增
     */
    @RequestMapping(value = "/assemble/create", method = RequestMethod.POST)
    Response create(@RequestBody AssembleDTO dto);

    /**
     * 拼团活动修改
     */
    @RequestMapping(value = "/assemble/modify", method = RequestMethod.PUT)
    Response modify(@RequestBody AssembleDTO dto);

    /**
     * 拼团活动规则详情
     */
    @RequestMapping(value = "/assemble/{activityId}/rule", method = RequestMethod.POST)
    Response ruleInfo(@PathVariable("activityId") Long activityId);

    /**
     * 拼团活动规则新增或者修改
     */
    @RequestMapping(value = "/assemble/rule/modify", method = RequestMethod.PUT)
    Response modifyRule(@RequestBody AssembleDTO dto);

    /**
     * 拼团活动商品详情
     */
    @RequestMapping(value = "/assemble/{activityId}/goods", method = RequestMethod.POST)
    Response assembleGoodsInfo(@PathVariable("activityId") Long activityId);

    /**
     * 拼团规则的商品
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    @RequestMapping(value = "/assemble/goods/modify", method = RequestMethod.PUT)
    Response assembleGoods(@RequestParam("activityId") Long activityId, @RequestParam("goodsId") Long goodsId);

    /**
     * 拼团成员
     */
    @RequestMapping(value = "/assemble/goods/members", method = RequestMethod.POST)
    Response members(@RequestBody AssembleDTO dto);
}
