package quick.pager.shop.job.helper;

import com.google.common.collect.Lists;
import java.util.List;
import quick.pager.shop.job.handler.IHandler;
import quick.pager.shop.job.handler.core.DeleteHandler;
import quick.pager.shop.job.handler.core.ExecuteHandler;
import quick.pager.shop.job.handler.core.ManualHandler;
import quick.pager.shop.job.handler.core.PauseHandler;
import quick.pager.shop.job.handler.core.ResumeHandler;
import quick.pager.shop.job.model.DTO;

/**
 * job 执行协助器
 *
 * @author siguiyang
 */
public class JobHelper {

    private static final List<IHandler> HANDLER = Lists.newArrayList();

    static {

        HANDLER.add(new DeleteHandler());
        HANDLER.add(new ExecuteHandler());
        HANDLER.add(new ManualHandler());
        HANDLER.add(new PauseHandler());
        HANDLER.add(new ResumeHandler());
    }

    /**
     * 执行核心job任务器
     */
    public static void execute(DTO dto) {

        for (IHandler handler : HANDLER) {
            if (handler.support(dto.getJobEnums())) {
                Long jobLogId = handler.preLog(dto.getJobId(), dto.getJobGroupId(), dto.getParams());
                handler.execute(dto.getJobId(), dto.getJobName());
                handler.postLog(jobLogId);
            }
        }
    }
}
