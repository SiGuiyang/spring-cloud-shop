package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.helper.JobHelper;
import quick.pager.shop.mapper.JobGroupMapper;
import quick.pager.shop.mapper.JobInfoMapper;
import quick.pager.shop.model.DTO;
import quick.pager.shop.model.JobGroup;
import quick.pager.shop.model.JobInfo;
import quick.pager.shop.job.request.JobGroupSaveRequest;
import quick.pager.shop.job.request.JobPageRequest;
import quick.pager.shop.job.request.JobRequest;
import quick.pager.shop.job.request.JobSaveRequest;
import quick.pager.shop.job.response.JobGroupResponse;
import quick.pager.shop.job.response.JobResponse;
import quick.pager.shop.service.JobService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;

/**
 * JobService 实现
 *
 * @author siguiyang
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobInfoMapper jobInfoMapper;
    @Autowired
    private JobGroupMapper jobGroupMapper;

    @Override
    public Response<List<JobResponse>> queryPage(final JobPageRequest request) {

        LambdaQueryWrapper<JobInfo> qw = this.toQuery(request.getJobName(), request.getJobGroup(), request.getJobStatus());
        int total = jobInfoMapper.selectCount(qw);
        List<JobResponse> responseList = Collections.emptyList();
        if (total > 0) {
            IPage<JobInfo> page = jobInfoMapper.selectPage(new Page<>(request.getPage(), request.getPageSize()), qw);
            responseList = page.getRecords().stream()
                    .map(this::convert)
                    .collect(Collectors.toList());
        }
        return Response.toResponse(responseList, total);
    }

    @Override
    public Response<List<JobResponse>> queryList(final JobRequest request) {

        LambdaQueryWrapper<JobInfo> qw = this.toQuery(request.getJobName(), request.getJobGroup(), request.getJobStatus());
        List<JobInfo> list = jobInfoMapper.selectList(qw);
        return Response.toResponse(list.stream()
                .map(this::convert)
                .collect(Collectors.toList()), 0L);
    }

    @Override
    public Response<List<JobGroupResponse>> queryGroupList(String jobGroup) {
        LambdaQueryWrapper<JobGroup> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(jobGroup)) {
            wrapper.likeRight(JobGroup::getGroupName, jobGroup);
        }

        List<JobGroup> jobGroups = jobGroupMapper.selectList(wrapper);

        return Response.toResponse(jobGroups.stream().map(item -> {
            JobGroupResponse jobGroupRes = new JobGroupResponse();
            jobGroupRes.setId(item.getId());
            jobGroupRes.setGroupName(item.getGroupName());
            jobGroupRes.setSequence(item.getSequence());
            return jobGroupRes;
        }).collect(Collectors.toList()));
    }

    @Override
    public Response<Long> create(final JobSaveRequest request) {

        JobGroup jobGroup = jobGroupMapper.selectById(request.getJobGroupId());
        if (Objects.isNull(jobGroup)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "任务组不存在");
        }
        JobInfo jobInfo = this.convert(request);
        jobInfo.setJobGroup(jobGroup.getGroupName());
        jobInfo.setJobStatus(JobStatusEnums.NORMAL.getCode());
        jobInfo.setCreateTime(LocalDateTime.now());
        jobInfo.setUpdateTime(LocalDateTime.now());
        jobInfoMapper.insert(jobInfo);
        JobHelper.execute(DTO.builder()
                .jobId(jobInfo.getId())
                .jobName(jobInfo.getJobName())
                .jobGroup(jobInfo.getJobGroup())
                .cron(jobInfo.getCron())
                .jobEnums(JobEnums.CREATE)
                .build());
        return Response.toResponse(jobInfo.getId());
    }

    @Override
    public Response<Long> create(final JobGroupSaveRequest request) {

        JobGroup jobGroup = new JobGroup();
        jobGroup.setGroupName(request.getName());
        jobGroup.setSequence(jobGroupMapper.selectMaxSequence());
        jobGroupMapper.insert(jobGroup);

        return Response.toResponse(jobGroup.getId());
    }

    @Override
    public Response<Long> modify(final JobSaveRequest request) {
        JobInfo jobInfo = this.convert(request);
        jobInfoMapper.updateById(jobInfo);
        return Response.toResponse(jobInfo.getId());
    }


    @Override
    public Response<JobResponse> info(final Long jobId) {
        JobInfo jobInfo = jobInfoMapper.selectById(jobId);
        return Response.toResponse(this.convert(jobInfo));
    }

    @Override
    public Response<String> doJob(final Long jobId, final String params, final JobEnums jobEnums) {
        JobInfo jobInfo = jobInfoMapper.selectById(jobId);
        if (Objects.isNull(jobInfo)) {
            return Response.toError(ResponseStatus.Code.FAIL_CODE, "未找到任务");
        }
        JobHelper.execute(DTO.builder().jobId(jobId).jobName(jobInfo.getJobName()).jobGroup(jobInfo.getJobGroup()).params(params).jobEnums(jobEnums).build());
        return Response.toResponse();
    }

    private LambdaQueryWrapper<JobInfo> toQuery(String jobName, String jobGroup, Integer jobStatus) {
        LambdaQueryWrapper<JobInfo> qw = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(jobName)) {
            qw.eq(JobInfo::getJobName, jobName);
        }

        if (StringUtils.isNotEmpty(jobGroup)) {
            qw.eq(JobInfo::getJobGroup, jobGroup);
        }

        if (Objects.nonNull(jobStatus)) {
            qw.eq(JobInfo::getJobStatus, jobStatus);
        }

        return qw;
    }

    private JobResponse convert(JobInfo jobInfo) {
        JobResponse response = new JobResponse();
        BeanCopier.copy(jobInfo, response);
        JobStatusEnums jobStatusEnums = JobStatusEnums.parse(jobInfo.getJobStatus());
        response.setJobStatusName(Objects.nonNull(jobStatusEnums) ? jobStatusEnums.getDesc() : StringUtils.EMPTY);
        return response;
    }

    private JobInfo convert(JobSaveRequest request) {
        return BeanCopier.create(request, new JobInfo()).copy();
    }
}
