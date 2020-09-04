package quick.pager.shop.handler.core;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
 * 从定时任务池中暂停
 *
 * @author siguiyang
 */
@Slf4j
public class PauseHandler extends AbstractHandler {

    @Override
    public boolean support(final JobEnums jobEnums) {
        return JobEnums.PAUSE.equals(jobEnums);
    }

    @Override
    public void execute(final String jobName, final String jobGroup) {
        log.info("执行暂停任务 jobName = {}, jobGroup = {}", jobName, jobGroup);
        Scheduler scheduler = ShopSpringContext.getBean(Scheduler.class);
        try {
            JobTrigger.pauseJob(scheduler, jobName, jobGroup);

            // 执行暂停成功后，执行暂定业务代码是
            JobInfoMapper jobInfoMapper = ShopSpringContext.getBean(JobInfoMapper.class);
            JobInfo jobInfo = new JobInfo();
            jobInfo.setJobStatus(JobStatusEnums.PAUSED.getCode());
            jobInfoMapper.update(jobInfo, new LambdaQueryWrapper<JobInfo>().eq(JobInfo::getJobName, jobName).eq(JobInfo::getJobGroup, jobGroup));
        } catch (SchedulerException e) {
            log.error("暂停定时任务失败 jobName = {}, jobGroup = {}", jobName, jobGroup);
        }
    }
}
