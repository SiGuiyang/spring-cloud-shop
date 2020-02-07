package quick.pager.shop.job.handler.core;

import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.handler.AbstractHandler;

/**
 * 从定时任务池中删除
 *
 * @author siguiyang
 */
public class DeleteHandler extends AbstractHandler {

    @Override
    public boolean support(JobEnums jobEnums) {
        return JobEnums.DELETE.equals(jobEnums);
    }

    @Override
    public void execute(Long jobId, String jobName) {

    }
}
