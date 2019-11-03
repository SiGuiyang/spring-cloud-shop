package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.dto.activity.ExchangeActivityDTO;
import quick.pager.shop.model.activity.ExchangeActivity;
import quick.pager.shop.response.Response;

/**
 * 满赠换购服务
 *
 * @author siguiyang
 */
public interface ExchangeService extends IPageService<ExchangeActivity> {

    /**
     * 活动详情
     *
     * @param activityId 满赠活动主键
     */
    Response<ExchangeActivity> exchangeInfo(Long activityId);

    /**
     * 满赠换购活动列表
     */
    Response<List<ExchangeActivity>> exchangeActivityList(ExchangeActivityDTO dto);

    /**
     * 创建或者修改活动
     */
    Response createOrModifyExchange(ExchangeActivityDTO dto);
}
