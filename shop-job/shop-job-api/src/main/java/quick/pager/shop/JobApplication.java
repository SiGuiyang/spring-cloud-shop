package quick.pager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 高扩展分布式定时任务启动
 *
 * @author siguiyang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
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
