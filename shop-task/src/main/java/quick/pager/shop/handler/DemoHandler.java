package quick.pager.shop.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@JobHandler(value = "DemoHandler")
public class DemoHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) throws Exception {

        System.out.println(Thread.currentThread().getName() + "DemoHandler");
        return SUCCESS;
    }
}
