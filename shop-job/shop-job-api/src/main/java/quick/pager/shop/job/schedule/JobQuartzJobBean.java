package quick.pager.shop.job.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.helper.JobHelper;
import quick.pager.shop.job.model.DTO;

/**
 * QuartzJobBean
 *
 * @author siguiyang
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Slf4j
public class JobQuartzJobBean extends QuartzJobBean {

    @SuppressWarnings("NullableProblems")
    @Override
    protected void executeInternal(JobExecutionContext context) {

        JobKey jobKey = context.getTrigger().getJobKey();
        String jobName = jobKey.getName();

        log.info("执行Job任务开始 jobName = {}", jobName);

        DTO dto = DTO.builder()
                .jobEnums(JobEnums.EXECUTE)
                .jobName(jobName)
                .build();
        JobHelper.execute(dto);

        log.info("执行Job任务完毕 jobName = {}", jobName);
    }
}
