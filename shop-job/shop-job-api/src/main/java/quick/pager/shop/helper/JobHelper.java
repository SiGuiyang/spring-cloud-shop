package quick.pager.shop.helper;

import com.google.common.collect.Lists;
import java.util.List;
import quick.pager.shop.handler.IHandler;
import quick.pager.shop.handler.core.CreateJobHandler;
import quick.pager.shop.handler.core.DeleteHandler;
import quick.pager.shop.handler.core.ExecuteHandler;
import quick.pager.shop.handler.core.ManualHandler;
import quick.pager.shop.handler.core.PauseHandler;
import quick.pager.shop.handler.core.ResumeHandler;
import quick.pager.shop.handler.core.UpdateJobHandler;
import quick.pager.shop.model.DTO;

/**
 * job 执行协助器
 *
 * @author siguiyang
 */
public final class JobHelper {

    private static final List<IHandler> HANDLER = Lists.newArrayList();

    static {
        HANDLER.add(new CreateJobHandler());
        HANDLER.add(new UpdateJobHandler());
        HANDLER.add(new DeleteHandler());
        HANDLER.add(new ExecuteHandler());
        HANDLER.add(new ManualHandler());
        HANDLER.add(new PauseHandler());
        HANDLER.add(new ResumeHandler());
    }

    /**
     * 执行核心job任务器
     */
    public static void execute(final DTO dto) {

        for (IHandler handler : HANDLER) {
            if (handler.support(dto.getJobEnums())) {
                Long jobLogId = handler.preLog(dto.getJobId(), dto.getJobGroupId(), dto.getParams());
                handler.execute(dto.getJobName(), dto.getJobGroup());
                handler.postLog(jobLogId);
            }
        }
    }
}
