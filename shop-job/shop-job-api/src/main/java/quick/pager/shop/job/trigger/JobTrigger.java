package quick.pager.shop.job.trigger;

import com.alibaba.fastjson.JSON;

import com.google.common.collect.Lists;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import java.util.List;
import java.util.Set;
import quick.pager.shop.job.enums.JobEnums;
import quick.pager.shop.job.enums.JobStatusEnums;
import quick.pager.shop.job.model.JobInfo;
import quick.pager.shop.job.schedule.JobQuartzJobBean;

/**
 * 任务调度工具类
 *
 * @author siguiyang
 */
@Slf4j
public class JobTrigger {
    /**
     * 根据job名称和job组名称获取触发key
     *
     * @param jobName  jobName
     * @param jobGroup jobGroup
     */
    private static TriggerKey getTriggerKey(String jobName, String jobGroup) {
        return TriggerKey.triggerKey(jobName, jobGroup);
    }

    /**
     * 获取表达式触发器
     *
     * @param scheduler 调度器
     * @param jobName   job名称
     * @param jobGroup  job组
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, String jobName, String jobGroup) {
        TriggerKey key = getTriggerKey(jobName, jobGroup);
        CronTrigger trigger = null;
        try {
            trigger = (CronTrigger) scheduler.getTrigger(key);
        } catch (SchedulerException e) {
            log.error("获取定时任务CronTrigger出现异常 jobName = {}, jobGroup = {}", jobName, jobGroup);
        }
        return trigger;
    }

    /**
     * 创建任务
     *
     * @param scheduler scheduler
     * @param job       job
     * @param params    params
     */
    public static void createJob(Scheduler scheduler, JobInfo job, Map<String, Object> params) {
        Class<? extends Job> jobClass = JobQuartzJobBean.class;

        // 构建job信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(job.getJobName(), job.getJobGroup()).build();
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron());
        // 按新的cron表达式构建一个新的trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                .withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error("创建定时任务失败，错误信息：{}", e);
        }

    }

    /**
     * 创建定时任务
     *
     * @param scheduler scheduler
     * @param job       job
     */
    public static void createJob(Scheduler scheduler, JobInfo job) {

        Class<? extends Job> jobClass = JobQuartzJobBean.class;

        TriggerKey key = getTriggerKey(job.getJobName(), job.getJobGroup());

        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(key);
            if (null == trigger) {
                // 构建job信息
                JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(job.getJobName(), job.getJobGroup())
                        .build();
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron());
                // 按新的cron表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron());
                trigger = TriggerBuilder.newTrigger().withIdentity(key).withSchedule(scheduleBuilder).build();
                scheduler.rescheduleJob(key, trigger);
            }
        } catch (SchedulerException e) {
            log.error("创建定时任务失败，错误信息：{}", e);
        }
    }

    /**
     * 获取所有job任务
     */
    public static List<JobInfo> getJobs(Scheduler scheduler) {
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();

        List<JobInfo> jobs = Lists.newArrayList();
        try {
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);

            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {

                    JobInfo event = new JobInfo();
                    event.setJobName(jobKey.getName());
                    event.setJobGroup(jobKey.getGroup());
                    event.setDescription("触发器：" + trigger.getKey());
                    Trigger.TriggerState state = scheduler.getTriggerState(trigger.getKey());
                    event.setJobStatus(EnumUtils.getEnum(JobStatusEnums.class, state.name()).getStatus());
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        event.setCron(cronTrigger.getCronExpression());
                    }
                    jobs.add(event);
                }
            }
            log.info("获取所有计划中的任务列表——————————{}", JSON.toJSONString(jobs));
        } catch (SchedulerException e) {
            log.error("获取所有定时任务失败");
        }
        return jobs;
    }

    /**
     * 获取正在运行的job任务
     *
     * @param scheduler scheduler
     */
    public static List<JobInfo> getRunningJobs(Scheduler scheduler) {

        try {
            List<JobExecutionContext> contexts = scheduler.getCurrentlyExecutingJobs();
            List<JobInfo> jobs = Lists.newArrayListWithCapacity(contexts.size());

            for (JobExecutionContext context : contexts) {
                JobInfo event = new JobInfo();
                JobDetail jobDetail = context.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = context.getTrigger();
                event.setJobName(jobKey.getName());
                event.setJobGroup(jobKey.getGroup());
                event.setDescription("触发器 ======== {}" + trigger.getKey());
                Trigger.TriggerState state = scheduler.getTriggerState(trigger.getKey());
                event.setJobStatus(EnumUtils.getEnum(JobStatusEnums.class, state.name()).getStatus());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    event.setCron(cronTrigger.getCronExpression());
                }
                jobs.add(event);
            }

            log.info("所有正在运行的job任务 ======== {}", JSON.toJSONString(jobs));
            return jobs;
        } catch (SchedulerException e) {
            log.error("未找到运行中的job任务：{}", e);
        }
        return null;
    }

    /**
     * 运行一次任务
     *
     * @param scheduler scheduler
     * @param jobName   jobName
     * @param jobGroup  jobGroup
     */
    public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            log.error("运行一次定时任务失败 ======== {}", e);
        }
    }

    /**
     * 暂停任务
     *
     * @param scheduler scheduler
     * @param jobName   jobName
     * @param jobGroup  jobGroup
     */
    public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error("暂停定时任务失败 ======== ", e);
        }
    }

    /**
     * 恢复任务
     *
     * @param scheduler scheduler
     * @param jobName   jobName
     * @param jobGroup  jobGroup
     */
    public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error("暂停定时任务失败 ======== ", e);
        }
    }

    /**
     * 获取jobKey
     *
     * @param jobName  the job name
     * @param jobGroup the job group
     * @return the job key
     */
    private static JobKey getJobKey(String jobName, String jobGroup) {

        return JobKey.jobKey(jobName, jobGroup);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler the scheduler
     */
    public static void updateJob(Scheduler scheduler, JobInfo job) {
        updateJob(scheduler, job.getJobName(), job.getJobGroup(), job.getCron(), job);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler      the scheduler
     * @param jobName        the job name
     * @param jobGroup       the job group
     * @param cronExpression the cron expression
     * @param param          the param
     */
    private static void updateJob(Scheduler scheduler, String jobName, String jobGroup, String cronExpression, Object param) {

        // 同步或异步
        Class<? extends Job> jobClass = JobQuartzJobBean.class;

        try {
            JobDetail jobDetail = scheduler.getJobDetail(getJobKey(jobName, jobGroup));

            jobDetail = jobDetail.getJobBuilder().ofType(jobClass).build();

            // 更新参数 实际测试中发现无法更新
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            jobDataMap.put("JobAdapter", param);
            jobDetail.getJobBuilder().usingJobData(jobDataMap);

            TriggerKey triggerKey = getTriggerKey(jobName, jobGroup);

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            // 忽略状态为PAUSED的任务，解决集群环境中在其他机器设置定时任务为PAUSED状态后，集群环境启动另一台主机时定时任务全被唤醒的bug
            if (!JobEnums.PAUSE.name().equalsIgnoreCase(triggerState.name())) {
                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (SchedulerException e) {
            log.error("更新定时任务失败——————————————————", e);
        }
    }

    /**
     * 删除定时任务
     *
     * @param scheduler scheduler
     * @param jobName   jobName
     * @param jobGroup  jobGroup
     */
    public static void deleteJob(Scheduler scheduler, String jobName, String jobGroup) {
        try {
            scheduler.deleteJob(getJobKey(jobName, jobGroup));
        } catch (SchedulerException e) {
            log.error("删除定时任务失败————————————————", e);
        }
    }

    /**
     * 通过反射执行定时任务的方法
     *
     * @param params job执行的参数
     */
    public static void invoke(Map<String, Object> params) {
    }
}
