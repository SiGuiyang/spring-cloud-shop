package quick.pager.shop.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.activity.mapper.ExchangeActivityMapper;
import quick.pager.shop.activity.model.ExchangeActivity;
import quick.pager.shop.activity.request.exchange.ExchangeActivityPageRequest;
import quick.pager.shop.activity.request.exchange.ExchangeActivitySaveRequest;
import quick.pager.shop.activity.response.exchange.ExchangeActivityResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.activity.service.ExchangeService;
import quick.pager.shop.service.impl.ServiceImpl;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
public class ExchangeServiceImpl extends ServiceImpl<ExchangeActivityMapper, ExchangeActivity> implements ExchangeService {


    @Override
    public Response<ExchangeActivityResponse> exchangeInfo(Long activityId) {
        ExchangeActivity activity = this.baseMapper.selectById(activityId);
        return new Response<>(this.convert(activity));
    }

    @Override
    public Response<List<ExchangeActivityResponse>> queryPage(ExchangeActivityPageRequest request) {

        QueryWrapper<ExchangeActivity> qw = new QueryWrapper<>();

        if (!StringUtils.isEmpty(request.getActivityName())) {
            qw.likeRight("activity_name", request.getActivityName());
        }

        if (!CollectionUtils.isEmpty(request.getTimeRange())) {
            qw.le("begin_time", request.getTimeRange().get(0));
            qw.ge("end_time", request.getTimeRange().get(1));
        }

        Response<List<ExchangeActivity>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(Optional.ofNullable(response.getData()).orElse(Collections.emptyList()).stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    @Override
    public Response<Long> create(ExchangeActivitySaveRequest request) {

        ExchangeActivity exchangeActivity = this.convert(request);

        exchangeActivity.setDeleteStatus(Boolean.FALSE);
        exchangeActivity.setServerStatus(Boolean.FALSE);
        exchangeActivity.setCreateTime(DateUtils.dateTime());
        this.baseMapper.insert(exchangeActivity);

        return new Response<>(exchangeActivity.getId());
    }

    @Override
    public Response<Long> modify(ExchangeActivitySaveRequest request) {
        ExchangeActivity exchangeActivity = this.convert(request);
        this.baseMapper.updateById(exchangeActivity);

        return new Response<>(exchangeActivity.getId());
    }

    private ExchangeActivity convert(ExchangeActivitySaveRequest request) {
        ExchangeActivity exchangeActivity = new ExchangeActivity();

        BeanCopier.create(request, exchangeActivity).copy();

        if (!CollectionUtils.isEmpty(request.getTimeRange())) {
            exchangeActivity.setBeginTime(request.getTimeRange().get(0));
            exchangeActivity.setEndTime(request.getTimeRange().get(1));
        }

        return exchangeActivity;
    }

    private ExchangeActivityResponse convert(ExchangeActivity activity) {
        ExchangeActivityResponse response = new ExchangeActivityResponse();
        BeanCopier.create(activity, response).copy();
        return response;
    }
}
