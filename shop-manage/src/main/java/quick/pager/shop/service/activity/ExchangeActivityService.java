package quick.pager.shop.service.activity;

import quick.pager.shop.response.Response;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;

/**
 * 满赠换购
 *
 * @author siguiyang
 */
public interface ExchangeActivityService {

    /**
     * 获取满赠换购活动列表
     */
    Response list(ExchangeActivityDTO dto);

    /**
     * 添加满赠换购活动
     */
    Response create(ExchangeActivityDTO dto);

    /**
     * 修改满赠换购活动
     */
    Response modify(ExchangeActivityDTO dto);

    /**
     * 活动规则列表
     */
    Response rules(ExchangeActivityDTO dto);

    /**
     * 活动规则新增
     */
    Response createRule(ExchangeActivityDTO dto);

    /**
     * 活动规则修改
     */
    Response modifyRule(ExchangeActivityDTO dto);

    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    Response info(Long activityId);

    /**
     * 购买记录
     */
    Response purchaseHistory(ExchangeActivityDTO dto);

    /**
     * 设置商品规则
     */
    Response goodsRule(ExchangeActivityDTO dto);

    /**
     * 查看换购商品的规则信息
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    Response goodsRuleInfo(Long activityId, Long goodsId);
}
