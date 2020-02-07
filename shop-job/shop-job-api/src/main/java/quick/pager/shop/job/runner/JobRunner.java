package quick.pager.shop.job.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import quick.pager.shop.context.ShopSpringContext;
import quick.pager.shop.job.mapper.JobInfoMapper;
import quick.pager.shop.job.model.JobInfo;
import quick.pager.shop.job.trigger.JobTrigger;

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
        List<JobInfo> jobInfos = jobInfoMapper.selectList(Wrappers.emptyWrapper());

        Optional.ofNullable(jobInfos).orElse(Collections.emptyList()).forEach(item -> {
            CronTrigger cronTrigger = JobTrigger.getCronTrigger(scheduler, item.getJobName(), item.getJobGroup());

            if (ObjectUtils.isEmpty(cronTrigger)) {
                JobTrigger.createJob(scheduler, item);
            } else {
                JobTrigger.updateJob(scheduler, item);
            }

        });

        log.info("结束加载job任务....");

    }
}
