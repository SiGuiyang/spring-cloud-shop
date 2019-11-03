package quick.pager.shop.service.client;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.ObjectUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.mapper.ExchangeActivityGoodsMapper;
import quick.pager.shop.mapper.ExchangeActivityMapper;
import quick.pager.shop.model.activity.ExchangeActivity;
import quick.pager.shop.model.activity.ExchangeActivityGoods;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.model.activity.ExchangeActivityRule;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;
import quick.pager.shop.service.IService;
import quick.pager.shop.utils.DateUtils;

/**
 * @author siguiyang
 */
@Service
@Slf4j
public class ExchangeActivityRuleService implements IService {

    @Autowired
    private ExchangeActivityRuleMapper exchangeActivityRuleMapper;
    @Autowired
    private ExchangeActivityGoodsMapper exchangeActivityGoodsMapper;
    @Autowired
    private ExchangeActivityMapper exchangeActivityMapper;

    @Override
    public Response doService(BaseDTO dto) {

        ExchangeActivityDTO exchangeActivityRuleDTO = (ExchangeActivityDTO) dto;
        Response response;
        switch (exchangeActivityRuleDTO.getEvent()) {
            case "exchangeRule":
                response = setGoodsRule(exchangeActivityRuleDTO.getActivityId(), exchangeActivityRuleDTO.getRuleId(), exchangeActivityRuleDTO.getGoodsId());
                break;
            case "exchangeGoodsRuleInfo":
                response = goodsRuleInfo(exchangeActivityRuleDTO.getActivityId(), exchangeActivityRuleDTO.getGoodsId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;

    }

    /**
     * 设置商品规则
     *
     * @param activityId 活动Id
     * @param ruleId     规则 Id
     * @param goodsId    商品Id
     */
    private Response setGoodsRule(Long activityId, Long ruleId, Long goodsId) {

        ExchangeActivityGoods exchangeActivityGoods = new ExchangeActivityGoods();
        exchangeActivityGoods.setActivityId(activityId);
        exchangeActivityGoods.setGoodsId(goodsId);

        ExchangeActivityGoods activityGoods = exchangeActivityGoodsMapper.select(exchangeActivityGoods);
        // 如果不存在，则新增
        if (ObjectUtils.isEmpty(activityGoods)) {
            exchangeActivityGoods.setRuleId(ruleId);
            exchangeActivityGoods.setCreateTime(DateUtils.now());
            exchangeActivityGoods.setDeleteStatus(Boolean.FALSE);
            exchangeActivityGoodsMapper.insert(exchangeActivityGoods);
        } else {
            ExchangeActivityGoods updateExchangeActivityGoods = new ExchangeActivityGoods();
            updateExchangeActivityGoods.setRuleId(ruleId);
            updateExchangeActivityGoods.setId(activityGoods.getId());
            exchangeActivityGoodsMapper.updateById(updateExchangeActivityGoods);

        }

        return new Response();

    }

    /**
     * 换购商品规则详情
     *
     * @param activityId 活动Id
     * @param goodsId    商品Id
     */
    private Response goodsRuleInfo(Long activityId, Long goodsId) {
        ExchangeActivityGoods exchangeActivityGoods = new ExchangeActivityGoods();
        exchangeActivityGoods.setActivityId(activityId);
        exchangeActivityGoods.setGoodsId(goodsId);
        ExchangeActivityGoods activityGoods = exchangeActivityGoodsMapper.select(exchangeActivityGoods);
        if (ObjectUtils.isEmpty(activityGoods)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, "此活动尚未配置规则");
        }

//        ExchangeActivity exchangeActivity = exchangeActivityMapper.selectByPrimaryKey(activityId);
//        ExchangeActivityRule exchangeActivityRule = exchangeActivityRuleMapper.selectByPrimaryKey(activityGoods.getRuleId());
//        exchangeActivityRule.setActivityName(exchangeActivity.getActivityName());
//        return new Response<>(exchangeActivityRule);
        return null;
    }
}
