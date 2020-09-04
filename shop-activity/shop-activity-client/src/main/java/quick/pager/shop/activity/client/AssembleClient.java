package quick.pager.shop.activity.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import quick.pager.shop.activity.request.assemble.AssembleMemberPageRequest;
import quick.pager.shop.activity.request.assemble.AssemblePageRequest;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.request.assemble.AssembleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityResponse;
import quick.pager.shop.activity.response.assemble.AssembleMemberResponse;
import quick.pager.shop.activity.response.assemble.AssembleResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.activity.fallback.FightGroupClientFallbackFactory;
import quick.pager.shop.user.response.Response;

/**
 * 拼团活动Client
 *
 * @author siguiyang
 * @version 1.0
 */
@FeignClient(value = ConstantsClient.ACTIVITY_CLIENT, path = ConstantsClient.ACTIVITY, fallbackFactory = FightGroupClientFallbackFactory.class)
public interface AssembleClient {

    /**
     * 拼团活动列表
     *
     * @param request 请求参数
     * @return 拼团活动列表
     */
    @RequestMapping(value = "/assemble/list", method = RequestMethod.POST)
    Response<List<AssembleActivityResponse>> list(@RequestBody AssemblePageRequest request);

    /**
     * 拼团活动新增
     *
     * @param request 请求参数
     * @return 规则主键
     */
    @RequestMapping(value = "/assemble/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody AssembleSaveRequest request);

    /**
     * 拼团活动修改
     *
     * @param request 请求参数
     * @return 活动主键
     */
    @RequestMapping(value = "/assemble/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody AssembleSaveRequest request);

    /**
     * 拼团活动规则详情
     *
     * @param activityId 拼团主键
     * @return 拼团活动规则详情
     */
    @RequestMapping(value = "/assemble/{activityId}/rule", method = RequestMethod.GET)
    Response<AssembleResponse> ruleInfo(@PathVariable("activityId") Long activityId);

    /**
     * 拼团活动规则新增
     *
     * @param request 请求参数
     * @return 规则主键
     */
    @RequestMapping(value = "/assemble/rule/create", method = RequestMethod.POST)
    Response<Long> create(@RequestBody AssembleRuleSaveRequest request);

    /**
     * 拼团活动规则新增或者修改
     *
     * @param request 请求参数
     * @return 规则主键
     */
    @RequestMapping(value = "/assemble/rule/modify", method = RequestMethod.PUT)
    Response<Long> modify(@RequestBody AssembleRuleSaveRequest request);

    /**
     * 拼团活动商品详情
     *
     * @param activityId 活动主键
     * @return 拼团活动商品详情
     */
    @RequestMapping(value = "/assemble/{activityId}/goods", method = RequestMethod.GET)
    Response assembleGoodsInfo(@PathVariable("activityId") Long activityId);

    /**
     * 拼团规则的商品
     *
     * @param activityId 活动主键
     * @param goodsId    商品主键
     * @return 拼团规则的商品
     */
    @RequestMapping(value = "/assemble/goods/modify", method = RequestMethod.PUT)
    Response assembleGoods(@RequestParam("activityId") Long activityId, @RequestParam("goodsId") Long goodsId);

    /**
     * 拼团成员
     *
     * @param request 请求参数
     * @return 拼团成员
     */
    @RequestMapping(value = "/assemble/members", method = RequestMethod.POST)
    Response<List<AssembleMemberResponse>> members(@RequestBody AssembleMemberPageRequest request);
}
