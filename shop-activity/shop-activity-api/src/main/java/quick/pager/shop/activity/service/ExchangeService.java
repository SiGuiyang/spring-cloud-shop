package quick.pager.shop.activity.service;

import java.util.List;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRecordPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRecordResponse;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.response.Response;

/**
 * 满赠换购服务
 *
 * @author siguiyang
 */
public interface ExchangeService {

    /**
     * 活动详情
     *
     * @param activityId 满赠活动主键
     */
    Response<ExchangeActivityResponse> queryInfo(Long activityId);

    /**
     * 满赠换购活动列表
     *
     * @param request 请求参数
     * @return 满赠换购活动列表
     */
    Response<List<ExchangeActivityResponse>> queryPage(ExchangeActivityPageRequest request);

    /**
     * 创建
     *
     * @param request 请求参数
     * @return 活动主键
     */
    Response<Long> create(ExchangeActivitySaveRequest request);

    /**
     * 修改活动
     *
     * @param request 请求参数
     * @return 活动主键
     */
    Response<Long> modify(ExchangeActivitySaveRequest request);

    /**
     * 满赠换购记录
     *
     * @param request 请求参数
     * @return 分页数据响应
     */
    Response<List<ExchangeActivityRecordResponse>> record(ExchangeActivityRecordPageRequest request);
}
