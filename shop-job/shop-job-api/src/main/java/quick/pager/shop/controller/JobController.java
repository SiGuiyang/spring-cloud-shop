package quick.pager.shop.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.job.request.JobGroupSaveRequest;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobGroupResponse;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.job.response.JobStatusResponse;
import quick.pager.shop.service.JobService;
import quick.pager.shop.user.response.Response;

/**
 * job 定时任务
 *
 * @author siguiyang
 */
@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;

    /**
     * 查询所有job列表
     */
    @GetMapping("/page")
    public Response<List<JobResponse>> page(JobPageRequest request) {
        return jobService.queryPage(request);
    }

    /**
     * 查询所有job列表
     */
    @GetMapping("/list")
    public Response<List<JobResponse>> list(JobRequest request) {
        return jobService.queryList(request);
    }

    /**
     * 查询任务状态列表
     */
    @GetMapping("/status/list")
    public Response<List<JobStatusResponse>> list() {

        return Response.toResponse(Stream.of(JobStatusEnums.values()).map(item -> {
            JobStatusResponse response = new JobStatusResponse();
            response.setCode(item.getCode());
            response.setDesc(item.getDesc());
            return response;
        }).collect(Collectors.toList()));
    }

    /**
     * 查询任务组列表
     *
     * @param jobGroup 任务组名称
     */
    @GetMapping("/group/list")
    public Response<List<JobGroupResponse>> list(@RequestParam(required = false) String jobGroup) {
        return jobService.queryGroupList(jobGroup);
    }

    /**
     * 新增任务组
     *
     * @param request 任务组
     */
    @PostMapping("/group/create")
    public Response<Long> create(@RequestBody JobGroupSaveRequest request) {
        return jobService.create(request);
    }

    /**
     * 更新job信息
     */
    @PutMapping("/modify")
    public Response<Long> modify(@RequestBody JobSaveRequest request) {
        if (Objects.isNull(request.getId())) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }
        return jobService.modify(request);
    }

    /**
     * 新增一个job任务
     */
    @PostMapping("/create")
    public Response<Long> create(@RequestBody JobSaveRequest request) {
        return jobService.create(request);
    }

    /**
     * 删除一个job 任务
     */
    @DeleteMapping("/delete/{jobId}")
    public Response delete(@PathVariable("jobId") Long jobId) {
        return jobService.doJob(jobId, null, JobEnums.DELETE);
    }

    /**
     * 执行job任务
     *
     * @param jobId job任务主键
     */
    @GetMapping("/execute/{jobId}")
    public Response execute(@PathVariable("jobId") Long jobId, @RequestBody String params) {
        return jobService.doJob(jobId, params, JobEnums.EXECUTE);
    }

    /**
     * 暂停到恢复job任务
     *
     * @param jobId job任务主键
     */
    @GetMapping("/resume/{jobId}")
    public Response resume(@PathVariable("jobId") Long jobId) {
        return jobService.doJob(jobId, null, JobEnums.RESUME);
    }

    /**
     * 暂停job任务
     *
     * @param jobId job任务主键
     */
    @GetMapping("/pause/{jobId}")
    public Response pause(@PathVariable("jobId") Long jobId) {
        return jobService.doJob(jobId, null, JobEnums.PAUSE);
    }

    /**
     * job任务详情
     *
     * @param jobId job任务主键
     */
    @GetMapping("/info/{jobId}")
    public Response info(@PathVariable("jobId") Long jobId) {
        return jobService.info(jobId);
    }
}
