package quick.pager.shop.handler.core;

import lombok.extern.slf4j.Slf4j;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.handler.AbstractHandler;

/**
 * 人工手动触发 执行器
 *
 * @author siguiyang
 */
@Slf4j
public class ManualHandler extends AbstractHandler {

    @Override
    public boolean support(final JobEnums jobEnums) {
        return JobEnums.MANUAL.equals(jobEnums);
    }

    @Override
    public void execute(final String jobName, final String jobGroup) {

        log.info("人工执行任务 jobName = {}, jobGroup = {}", jobName, jobGroup);
    }
}
