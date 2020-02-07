package quick.pager.shop.job.handler.core;

import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.handler.AbstractHandler;

/**
 * 人工手动触发 执行器
 *
 * @author siguiyang
 */
public class ManualHandler extends AbstractHandler {

    @Override
    public boolean support(JobEnums jobEnums) {
        return JobEnums.MANUAL.equals(jobEnums);
    }

    @Override
    public void execute(Long jobId, String jobName) {

    }
}
