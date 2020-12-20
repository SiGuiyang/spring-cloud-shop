package quick.pager.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.activity.request.ActivityOtherRequest;
import quick.pager.shop.activity.request.ActivityPageRequest;
import quick.pager.shop.activity.request.ActivitySaveRequest;
import quick.pager.shop.activity.response.ActivityResponse;
import quick.pager.shop.mapper.ActivityMapper;
import quick.pager.shop.model.Activity;
import quick.pager.shop.platform.client.SystemConfigClient;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.service.ActivityService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

@Service
@Slf4j
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {


    @Autowired
    private SystemConfigClient systemConfigClient;

    @Override
    public boolean nonExists(final Long activityId) {
        Activity activity = this.baseMapper.selectById(activityId);
        return Objects.isNull(activity) || activity.getDeleteStatus();
    }

    @Override
    public Response<ActivityResponse> queryInfo(Long activityId) {
        Activity activity = this.baseMapper.selectById(activityId);
        return Response.toResponse(this.convert(activity));
    }

    @Override
    public Response<Long> create(final ActivitySaveRequest request) {

        Activity activity = this.convert(request);
        activity.setState(Boolean.FALSE);
        activity.setCreateTime(DateUtils.dateTime());
        activity.setUpdateTime(DateUtils.dateTime());
        activity.setDeleteStatus(Boolean.FALSE);
        this.baseMapper.insert(activity);
        return Response.toResponse(activity.getId());
    }

    @Override
    public Response<Long> modify(final ActivitySaveRequest request) {
        Activity activity = this.convert(request);
        activity.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.update(activity, new LambdaQueryWrapper<Activity>().eq(Activity::getId, request.getId()));
        return Response.toResponse(activity.getId());
    }

    @Override
    public Response<List<ActivityResponse>> queryList(final ActivityOtherRequest request) {
        LambdaQueryWrapper<Activity> qw = new LambdaQueryWrapper<Activity>()
                .eq(Activity::getState, Boolean.TRUE)
                .likeRight(StringUtils.isNotEmpty(request.getKeyword()), Activity::getActivityName, request.getKeyword())
                .eq(StringUtils.isNotEmpty(request.getName()), Activity::getActivityName, request.getName())
                .eq(Objects.nonNull(request.getActivityType()), Activity::getActivityType, request.getActivityType())
                .between(CollectionUtils.isNotEmpty(request.getRange()), Activity::getBeginTime, request.getRange().get(0), request.getRange().get(1));

        List<Activity> list = this.baseMapper.selectList(qw);
        return Response.toResponse(list.stream().map(this::convert).collect(Collectors.toList()));
    }

    @Override
    public Response<List<ActivityResponse>> queryPage(final ActivityPageRequest request) {
        log.info("请求参数 {}", JSON.toJSONString(request));

        Response<List<SystemConfigResponse>> listResponse = systemConfigClient.queryPage(new SystemConfigPageRequest());
        System.out.println(listResponse);
        LambdaQueryWrapper<Activity> qw = new LambdaQueryWrapper<Activity>()
                .likeRight(StringUtils.isNotEmpty(request.getKeyword()), Activity::getActivityName, request.getKeyword())
                .eq(StringUtils.isNotEmpty(request.getName()), Activity::getActivityName, request.getName())
                .eq(Objects.nonNull(request.getState()), Activity::getState, request.getState())
                .eq(Objects.nonNull(request.getActivityType()), Activity::getActivityType, request.getActivityType());
        if (CollectionUtils.isNotEmpty(request.getRange())) {

            qw.between(Activity::getBeginTime, DateUtils.parseLocalDateTime(request.getRange().get(0)), DateUtils.parseLocalDateTime(request.getRange().get(1)));
        }
        Response<List<Activity>> response = this.toPage(request.getPage(), request.getPageSize(), qw);

        return Response.toResponse(response.getData().stream()
                        .map(this::convert)
                        .collect(Collectors.toList()),
                response.getTotal());
    }

    private Activity convert(final ActivitySaveRequest request) {
        return BeanCopier.copy(request, new Activity());
    }

    private ActivityResponse convert(final Activity activity) {
        return BeanCopier.copy(activity, new ActivityResponse());
    }
}
