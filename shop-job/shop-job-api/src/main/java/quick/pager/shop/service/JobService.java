package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.request.JobGroupSaveRequest;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobGroupResponse;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.user.response.Response;

/**
 * Job Service 服务
 *
 * @author siguiyang
 */
public interface JobService {

    /**
     * 分页请求
     */
    Response<List<JobResponse>> queryPage(final JobPageRequest request);

    /**
     * 无分页列表数据
     */
    Response<List<JobResponse>> queryList(final JobRequest request);

    /**
     * 任务组列表
     *
     * @param jobGroup 任务组名称
     */
    Response<List<JobGroupResponse>> queryGroupList(final String jobGroup);

    /**
     * 保存
     */
    Response<Long> create(final JobSaveRequest request);

    /**
     * 保存
     */
    Response<Long> create(final JobGroupSaveRequest request);

    /**
     * 修改
     */
    Response<Long> modify(final JobSaveRequest request);

    /**
     * 查看Job信息
     *
     * @param jobId job主键
     */
    Response<JobResponse> info(final Long jobId);

    /**
     * 手工执行job任务
     *
     * @param jobId    job 主键
     * @param params   动态参数
     * @param jobEnums job枚举
     */
    Response doJob(final Long jobId, final String params, final JobEnums jobEnums);
}
