package quick.pager.shop.runner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.helper.JobHelper;
import quick.pager.shop.mapper.JobInfoMapper;
import quick.pager.shop.model.DTO;
import quick.pager.shop.model.JobInfo;
import quick.pager.shop.trigger.JobTrigger;

/**
 * 应用加载完成后，向定时任务池加任务
 *
 * @author siguiyang
 */
@Component
@Slf4j
public class JobRunner implements CommandLineRunner {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {
        log.info("开始加载job任务....");
        JobInfoMapper jobInfoMapper = ShopSpringContext.getBean(JobInfoMapper.class);
        List<JobInfo> jobInfos = jobInfoMapper.selectList(new LambdaQueryWrapper<JobInfo>().eq(JobInfo::getJobStatus, JobStatusEnums.NORMAL.getCode()));

        jobInfos.forEach(item -> {
            CronTrigger cronTrigger = null;
            try {
                cronTrigger = JobTrigger.getCronTrigger(scheduler, item.getJobName(), item.getJobGroup());
            } catch (SchedulerException e) {
                log.error("获取job任务定时器失败 jobName = {}, jobGroup = {}", item.getJobName(), item.getJobGroup());
            }

            if (Objects.nonNull(cronTrigger)) {
                DTO dto = DTO.builder()
                        .jobId(item.getId())
                        .jobName(item.getJobName())
                        .jobGroup(item.getJobGroup())
                        .cron(item.getCron())
                        .jobEnums(JobEnums.UPDATE)
                        .build();
                JobHelper.execute(dto);
            } else {
                DTO dto = DTO.builder()
                        .jobId(item.getId())
                        .jobName(item.getJobName())
                        .jobGroup(item.getJobGroup())
                        .cron(item.getCron())
                        .jobEnums(JobEnums.CREATE)
                        .build();
                JobHelper.execute(dto);
            }

        });

        log.info("结束加载job任务....");

    }
}
