package quick.pager.shop.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.helper.JobHelper;
import quick.pager.shop.model.DTO;

/**
 * QuartzJobBean
 *
 * @author siguiyang
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Slf4j
public class JobQuartzJobBean extends QuartzJobBean {

    /**
     * job任务主键
     */
    private Long jobId;
    /**
     * job组主键
     */
    private Long jobGroupId;
    /**
     * 全局唯一的job任务名称
     */
    private String jobName;
    /**
     * 执行参数
     */
    private String params;

    /**
     * job执行方式
     */
    private JobEnums jobEnums;

    @Override
    protected void executeInternal(JobExecutionContext context) {

        log.info("执行Job任务开始 jobName = {}, method = {}", jobName, jobEnums);
        DTO dto = DTO.builder()
                .jobGroupId(jobGroupId)
                .jobId(jobId)
                .jobName(jobName)
                .jobEnums(jobEnums)
                .params(params)
                .build();
        JobHelper.execute(dto);

        log.info("执行Job任务完毕 jobName = {}, method = {}", jobName, jobEnums);
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobGroupId(Long jobGroupId) {
        this.jobGroupId = jobGroupId;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setJobEnums(JobEnums jobEnums) {
        this.jobEnums = jobEnums;
    }
}
