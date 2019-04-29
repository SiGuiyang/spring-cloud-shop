package quick.pager.shop.service;

import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.model.ExchangeActivityRule;
import quick.pager.shop.mapper.ExchangeActivityRuleMapper;

/**
* @author siguiyang
*/
@Service
@Slf4j
public class ExchangeActivityRuleService implements IService {

    @Autowired
    private ExchangeActivityRuleMapper exchangeActivityRuleMapper;

    @Override
    public Response doService(BaseDTO dto) {

        ExchangeActivityDTO exchangeActivityRuleDTO = (ExchangeActivityDTO) dto;
        Response response;
        switch (exchangeActivityRuleDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyExchangeActivityRule(exchangeActivityRuleDTO);
                break;
            case Constants.Event.LIST:
                response = selectExchangeActivityRules(exchangeActivityRuleDTO);
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;

    }

    /**
     * 新增修改
     */
    private Response modifyExchangeActivityRule(ExchangeActivityDTO exchangeActivityRuleDTO) {
        ExchangeActivityRule exchangeActivityRule = new ExchangeActivityRule();
        BeanUtils.copyProperties(exchangeActivityRuleDTO, exchangeActivityRule);
        if (Constants.Event.ADD.equals(exchangeActivityRuleDTO.getEvent())) { // 新增
            exchangeActivityRule.setDeleteStatus(false);
            exchangeActivityRule.setCreateTime(new Date());
            exchangeActivityRuleMapper.insertSelective(exchangeActivityRule);
        } else {
            exchangeActivityRuleMapper.updateByPrimaryKeySelective(exchangeActivityRule);
        }
        return new Response();
    }

    /**
     * 查询列表
     */
    private Response selectExchangeActivityRules(ExchangeActivityDTO exchangeActivityRuleDTO) {
        List<ExchangeActivityRule> result = exchangeActivityRuleMapper.select(exchangeActivityRuleDTO.getActivityId());
        return Response.toResponse(result);
    }
}
