package quick.pager.shop.job.handler;

import java.time.LocalDateTime;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.job.mapper.JobInfoMapper;
import quick.pager.shop.job.mapper.JobLogMapper;
import quick.pager.shop.job.model.JobInfo;
import quick.pager.shop.job.model.JobLog;

/**
 * 抽离记录日志的方式
 *
 * @author siguiyang
 */
public abstract class AbstractHandler implements IHandler {

    @Override
    public Long preLog(Long jobId, Long jobGroupId, String executorsParam) {
        JobInfoMapper jobInfoMapper = ShopSpringContext.getBean(JobInfoMapper.class);
        JobLogMapper jobLogMapper = ShopSpringContext.getBean(JobLogMapper.class);

        JobInfo jobInfo = jobInfoMapper.selectById(jobId);
        JobLog jobLog = new JobLog();
        jobLog.setJobId(jobId);
        jobLog.setJobGroupId(jobGroupId);
        jobLog.setExecutorServiceName(jobInfo.getServiceName());
        jobLog.setExecutorServiceMethod(jobInfo.getServiceMethod());
        jobLog.setExecutorParam(executorsParam);

        jobLogMapper.insert(jobLog);
        return jobLog.getId();
    }

    @Override
    public void postLog(Long jobLogId) {
        JobLogMapper jobLogMapper = ShopSpringContext.getBean(JobLogMapper.class);
        JobLog updateJobLog = new JobLog();
        updateJobLog.setId(jobLogId);
        updateJobLog.setHandleTime(LocalDateTime.now());
        jobLogMapper.updateById(updateJobLog);
    }
}
