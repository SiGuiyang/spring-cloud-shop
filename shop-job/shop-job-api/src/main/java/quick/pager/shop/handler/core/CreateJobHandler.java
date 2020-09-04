package quick.pager.shop.handler.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.handler.AbstractHandler;
import quick.pager.shop.mapper.JobInfoMapper;
import quick.pager.shop.model.JobInfo;
import quick.pager.shop.trigger.JobTrigger;

/**
 * 任务创建
 *
 * @author siguiyang
 */
@Slf4j
public class CreateJobHandler extends AbstractHandler {
    @Override
    public boolean support(JobEnums jobEnums) {
        return JobEnums.CREATE.equals(jobEnums);
    }

    @Override
    public void execute(String jobName, String jobGroup) {

        log.info("新增job任务 jobName = {}, jobGroup = {}", jobName, jobGroup);

        // 1. 获取数据库执行的job任务
        JobInfoMapper jobInfoMapper = ShopSpringContext.getBean(JobInfoMapper.class);
        JobInfo jobInfo = new JobInfo();
        jobInfo.setJobName(jobName);
        jobInfo.setJobGroup(jobGroup);
        jobInfo.setJobStatus(JobStatusEnums.NORMAL.getCode());
        JobInfo selectJobInfo = jobInfoMapper.selectOne(new QueryWrapper<>(jobInfo));
        Scheduler scheduler = ShopSpringContext.getBean(Scheduler.class);
        try {
            // 2. 获取数据库执行的job任务
            JobTrigger.createJob(scheduler, selectJobInfo);
        } catch (SchedulerException e) {
            log.error("创建定时任务失败 jobName = {}, jobGroup = {}", jobName, jobGroup);
        }

    }
}
