package quick.pager.shop.job;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.quartz.JobQuartzJobBean;

/**
 * 高扩展分布式定时任务启动
 *
 * @author siguiyang
 */
@SpringBootApplication(scanBasePackages = "quick.pager.shop")
@EnableDiscoveryClient
@EnableFeignClients("quick.pager.shop")
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

//    @Bean
//    public JobDetail sampleJobDetail() {
//        JobDataMap map = new JobDataMap();
//        map.put("jobName", "dfdf");
//        map.put("jobGroup", "test");
//        map.put("jobStatus", JobEnums.EXECUTE);
//        return JobBuilder.newJob(JobQuartzJobBean.class).withIdentity("sampleJob")
//                .usingJobData(map).storeDurably().build();
//    }
//
//    @Bean
//    public Trigger sampleJobTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(2).repeatForever();
//
//        return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
//                .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
//    }
}
