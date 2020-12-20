package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.ActivityOtherRequest;
import quick.pager.shop.activity.request.ActivityPageRequest;
import quick.pager.shop.activity.request.ActivitySaveRequest;
import quick.pager.shop.activity.response.ActivityResponse;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.service.ActivityService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.Assert;

/**
 * 主活动
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    /**
     * 获取活动
     *
     * @param activityId 活动Id
     */
    @GetMapping("/master/{activityId}")
    public Response<ActivityResponse> info(@PathVariable("activityId") Long activityId) {
        return activityService.queryInfo(activityId);
    }

    /**
     * 活动创建
     *
     * @param request 请求参数
     */
    @PostMapping("/master/create")
    public Response<Long> create(@RequestBody ActivitySaveRequest request) {

        return activityService.create(request);

    }

    /**
     * 活动修改
     *
     * @param request 请求参数
     */
    @PutMapping("/master/modify")
    public Response<Long> modify(@RequestBody ActivitySaveRequest request) {
        Assert.isTrue(Objects.nonNull(request.getId()), () -> ResponseStatus.PARAMS_EXCEPTION);
        return activityService.modify(request);

    }

    /**
     * 活动列表
     *
     * @param request 请求参数
     */
    @PostMapping("/master/list")
    public Response<List<ActivityResponse>> list(@RequestBody ActivityOtherRequest request) {

        return activityService.queryList(request);

    }

    /**
     * 活动列表
     *
     * @param request 请求参数
     */
    @PostMapping("/master/page")
    public Response<List<ActivityResponse>> page(@RequestBody ActivityPageRequest request) {

        return activityService.queryPage(request);

    }
}
