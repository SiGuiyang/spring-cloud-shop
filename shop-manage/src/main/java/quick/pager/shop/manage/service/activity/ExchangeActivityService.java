package quick.pager.shop.manage.service.activity;

import java.util.List;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRuleResponse;
import quick.pager.shop.manage.param.exchange.ExchangeActivityPageParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityRulePageParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivityRuleSaveParam;
import quick.pager.shop.manage.param.exchange.ExchangeActivitySaveParam;
import quick.pager.shop.response.Response;

/**
 * 满赠换购
 *
 * @author siguiyang
 */
public interface ExchangeActivityService {

    /**
     * 获取满赠换购活动列表
     */
    Response<List<ExchangeActivityResponse>> list(ExchangeActivityPageParam param);

    /**
     * 添加满赠换购活动
     */
    Response<Long> create(ExchangeActivitySaveParam param);

    /**
     * 修改满赠换购活动
     */
    Response<Long> modify(ExchangeActivitySaveParam param);

    /**
     * 活动规则列表
     */
    Response<List<ExchangeActivityRuleResponse>> rules(Long activityId);

    /**
     * 活动规则新增
     */
    Response<Long> createRule(ExchangeActivityRuleSaveParam param);

    /**
     * 活动规则修改
     */
    Response<Long> modifyRule(ExchangeActivityRuleSaveParam param);

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    Response<ExchangeActivityResponse> info(Long activityId);

    /**
     * 购买记录
     */
    Response purchaseHistory(ExchangeActivityParam param);

    /**
     * 设置商品规则
     */
    Response goodsRule(ExchangeActivityParam param);

    /**
     * 查看换购商品的规则信息
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    Response goodsRuleInfo(Long activityId, Long goodsId);
}
