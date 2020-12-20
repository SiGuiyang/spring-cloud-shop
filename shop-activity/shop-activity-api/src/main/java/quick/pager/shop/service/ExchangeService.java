package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.activity.request.exchange.ExchangeActivityRecordPageRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityRecordResponse;
import quick.pager.shop.user.response.Response;

/**
 * 满赠换购服务
 *
 * @author siguiyang
 */
public interface ExchangeService {

    /**
     * 满赠换购记录
     *
     * @param request 请求参数
     * @return 分页数据响应
     */
    Response<List<ExchangeActivityRecordResponse>> record(final ExchangeActivityRecordPageRequest request);
}
