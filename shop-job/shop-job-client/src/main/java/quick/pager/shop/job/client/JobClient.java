package quick.pager.shop.job.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.job.fallback.JobFallbackFactory;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.user.response.Response;

@FeignClient(value = ConstantsClient.JOB_CLIENT, path = ConstantsClient.JOB, fallbackFactory = JobFallbackFactory.class)
public interface JobClient {

    /**
     * 查询所有job列表
     */
    @GetMapping("/page")
    Response<List<JobResponse>> page(JobPageRequest request);

    /**
     * 查询所有job列表
     */
    @GetMapping("/list")
    Response<List<JobResponse>> list(JobRequest request);

    /**
     * 更新job信息
     */
    @PutMapping("/modify")
    Response<Long> modify(@RequestBody JobSaveRequest request);

    /**
     * 新增一个job任务
     */
    @PostMapping("/create")
    Response<Long> create(@RequestBody JobSaveRequest request);

    /**
     * 删除一个job 任务
     */
    @DeleteMapping("/delete/{jobId}")
    Response delete(@PathVariable("jobId") Long jobId);

    /**
     * 执行job任务
     *
     * @param jobId job任务主键
     */
    @GetMapping("/execute/{jobId}")
    Response execute(@PathVariable("jobId") Long jobId);

    /**
     * 暂停到恢复job任务
     *
     * @param jobId job任务主键
     */
    @GetMapping("/resume/{jobId}")
    Response resume(@PathVariable("jobId") Long jobId);

    /**
     * 暂停job任务
     *
     * @param jobId job任务主键
     */
    @GetMapping("/pause/{jobId}")
    Response pause(@PathVariable("jobId") Long jobId);

    /**
     * job任务详情
     *
     * @param jobId job任务主键
     */
    @GetMapping("/info/{jobId}")
    Response info(@PathVariable("jobId") Long jobId);
}
