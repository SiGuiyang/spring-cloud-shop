package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.activity.request.ActivityOtherRequest;
import quick.pager.shop.activity.request.ActivityPageRequest;
import quick.pager.shop.activity.request.ActivitySaveRequest;
import quick.pager.shop.activity.response.ActivityResponse;
import quick.pager.shop.model.Activity;
import quick.pager.shop.user.response.Response;

/**
 * 主活动
 *
 * @author siguiyang
 */
public interface ActivityService extends IService<Activity> {

    /**
     * 验证活动是否存在
     *
     * @param activityId 活动主键
     * @return true 不存在， false 存在
     */
    boolean nonExists(final Long activityId);

    /**
     * 活动详情
     *
     * @param activityId 满赠活动主键
     */
    Response<ActivityResponse> queryInfo(final Long activityId);

    /**
     * 创建活动
     *
     * @param request 请求参数
     */
    Response<Long> create(final ActivitySaveRequest request);

    /**
     * 修改活动
     *
     * @param request 请求参数
     */
    Response<Long> modify(final ActivitySaveRequest request);


    /**
     * 查询商品活动列表
     *
     * @param request 请求参数
     */
    Response<List<ActivityResponse>> queryList(final ActivityOtherRequest request);

    /**
     * 查询商品活动列表分页
     *
     * @param request 请求参数
     */
    Response<List<ActivityResponse>> queryPage(final ActivityPageRequest request);
}
