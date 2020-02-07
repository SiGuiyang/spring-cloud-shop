package quick.pager.shop.job.service;

import java.util.List;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.response.Response;

/**
 * Job Service 服务
 *
 * @author siguiyang
 */
public interface JobService {

    /**
     * 分页请求
     */
    Response<List<JobResponse>> queryPage(JobPageRequest request);

    /**
     * 无分页列表数据
     */
    Response<List<JobResponse>> queryList(JobRequest request);

    /**
     * 保存
     */
    Response<Long> create(JobSaveRequest request);

    /**
     * 修改
     */
    Response<Long> modify(JobSaveRequest request);

    /**
     * 查看Job信息
     *
     * @param jobId job主键
     */
    Response<JobResponse> info(Long jobId);

    /**
     * 手工执行job任务
     *
     * @param jobId    job 主键
     * @param jobEnums job枚举
     */
    Response doJob(Long jobId, JobEnums jobEnums);
}
