package quick.pager.shop.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.helper.JobHelper;
import quick.pager.shop.job.mapper.JobInfoMapper;
import quick.pager.shop.job.model.DTO;
import quick.pager.shop.job.model.JobInfo;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.job.service.JobService;
import quick.pager.shop.response.Response;
import quick.pager.shop.utils.BeanCopier;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobInfoMapper jobInfoMapper;

    @Override
    public Response<List<JobResponse>> queryPage(JobPageRequest request) {

        QueryWrapper<JobInfo> qw = this.toQuery(request.getJobName(), request.getJobGroup(), request.getJobStatus());
        int total = jobInfoMapper.selectCount(qw);
        List<JobResponse> responseList = Collections.emptyList();
        if (total > 0) {
            IPage<JobInfo> page = jobInfoMapper.selectPage(new Page<>(request.getPage(), request.getPageSize()), qw);
            responseList = Optional.ofNullable(page.getRecords()).orElse(Collections.emptyList()).stream()
                    .map(this::convert)
                    .collect(Collectors.toList());
        }
        return Response.toResponse(responseList, total);
    }

    @Override
    public Response<List<JobResponse>> queryList(JobRequest request) {

        QueryWrapper<JobInfo> qw = this.toQuery(request.getJobName(), request.getJobGroup(), request.getJobStatus());
        List<JobInfo> list = jobInfoMapper.selectList(qw);
        return Response.toResponse(Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
                .map(this::convert)
                .collect(Collectors.toList()), 0L);
    }

    @Override
    public Response<Long> create(JobSaveRequest request) {

        JobInfo jobInfo = this.convert(request);
        jobInfo.setCreateTime(LocalDateTime.now());
        jobInfoMapper.insert(jobInfo);

        return new Response<>(jobInfo.getId());
    }

    @Override
    public Response<Long> modify(JobSaveRequest request) {
        JobInfo jobInfo = this.convert(request);
        jobInfoMapper.updateById(jobInfo);
        return new Response<>(jobInfo.getId());
    }


    @Override
    public Response<JobResponse> info(Long jobId) {
        JobInfo jobInfo = jobInfoMapper.selectById(jobId);
        return new Response<>(this.convert(jobInfo));
    }

    @Override
    public Response doJob(Long jobId, JobEnums jobEnums) {
        JobHelper.execute(DTO.builder().jobId(jobId).jobEnums(jobEnums).build());
        return new Response();
    }

    private QueryWrapper<JobInfo> toQuery(String jobName, String jobGroup, Integer jobStatus) {
        JobInfo jobInfo = new JobInfo();
        if (!StringUtils.isEmpty(jobName)) {
            jobInfo.setJobName(jobName);
        }

        if (StringUtils.isEmpty(jobGroup)) {
            jobInfo.setJobGroup(jobGroup);
        }

        if (Objects.nonNull(jobStatus)) {
            jobInfo.setJobStatus(jobStatus);
        }

        return new QueryWrapper<>(jobInfo);
    }

    private JobResponse convert(JobInfo jobInfo) {
        return BeanCopier.create(jobInfo, new JobResponse()).copy();
    }

    private JobInfo convert(JobSaveRequest request) {
        return BeanCopier.create(request, new JobInfo()).copy();
    }
}
