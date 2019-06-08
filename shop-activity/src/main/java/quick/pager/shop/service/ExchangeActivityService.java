package quick.pager.shop.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.dto.ExchangeActivityDTO;
import quick.pager.shop.mapper.ExchangeActivityMapper;
import quick.pager.shop.model.activity.ExchangeActivity;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.DateUtils;

@Service
public class ExchangeActivityService implements IService {

    @Autowired
    private ExchangeActivityMapper exchangeActivityMapper;

    @Override
    public Response doService(BaseDTO dto) {

        ExchangeActivityDTO exchangeActivityDTO = (ExchangeActivityDTO) dto;
        Response response;
        switch (exchangeActivityDTO.getEvent()) {
            case Constants.Event.ADD:
            case Constants.Event.MODIFY:
                response = modifyExchangeActivity(exchangeActivityDTO);
                break;
            case Constants.Event.LIST:
                response = selectExchangeActivitys(exchangeActivityDTO);
                break;
            case Constants.Event.INFO:
                response = getExchangeActivity(exchangeActivityDTO.getActivityId());
                break;
            default:
                response = new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return response;

    }

    private Response getExchangeActivity(Long activityId) {

        return new Response<>(exchangeActivityMapper.selectByPrimaryKey(activityId));
    }

    /**
     * 新增修改
     */
    private Response modifyExchangeActivity(ExchangeActivityDTO exchangeActivityDTO) {
        ExchangeActivity exchangeActivity = new ExchangeActivity();
        BeanUtils.copyProperties(exchangeActivityDTO, exchangeActivity);
        if (!StringUtils.isEmpty(exchangeActivityDTO.getBeginTime())) {
            exchangeActivity.setBeginTime(DateUtils.parse(exchangeActivityDTO.getBeginTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (!StringUtils.isEmpty(exchangeActivityDTO.getEndTime())) {
            exchangeActivity.setEndTime(DateUtils.parse(exchangeActivityDTO.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (Constants.Event.ADD.equals(exchangeActivityDTO.getEvent())) { // 新增
            exchangeActivity.setDeleteStatus(false);
            exchangeActivity.setCreateTime(DateUtils.now());
            exchangeActivityMapper.insertSelective(exchangeActivity);
        } else {
            exchangeActivityMapper.updateByPrimaryKeySelective(exchangeActivity);
        }
        return new Response();
    }

    /**
     * 查询列表
     */
    private Response selectExchangeActivitys(ExchangeActivityDTO exchangeActivityDTO) {
        List<ExchangeActivity> result = exchangeActivityMapper.select(exchangeActivityDTO.getActivityName());
        return Response.toResponse(result);
    }
}
