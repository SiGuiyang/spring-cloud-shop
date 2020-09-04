package quick.pager.shop.handler;

import java.time.LocalDateTime;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.mapper.JobInfoMapper;
import quick.pager.shop.mapper.JobLogMapper;
import quick.pager.shop.model.JobInfo;
import quick.pager.shop.model.JobLog;

/**
 * 抽离记录日志的方式
 *
 * @author siguiyang
 */
public abstract class AbstractHandler implements IHandler {

    @Override
    public final Long preLog(final Long jobId, final Long jobGroupId, final String executorsParam) {
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
    public final void postLog(final Long jobLogId) {
        JobLogMapper jobLogMapper = ShopSpringContext.getBean(JobLogMapper.class);
        JobLog updateJobLog = new JobLog();
        updateJobLog.setId(jobLogId);
        updateJobLog.setHandleTime(LocalDateTime.now());
        jobLogMapper.updateById(updateJobLog);
    }
}
