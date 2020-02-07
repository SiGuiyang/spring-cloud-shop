package quick.pager.shop.job.handler.core;

import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.handler.AbstractHandler;

/**
 * 从定时任务池中暂停
 *
 * @author siguiyang
 */
public class PauseHandler extends AbstractHandler {

    @Override
    public boolean support(JobEnums jobEnums) {
        return JobEnums.PAUSE.equals(jobEnums);
    }

    @Override
    public void execute(Long jobId, String jobName) {

    }
}
