package quick.pager.shop.handler;

import quick.pager.shop.job.enums.JobEnums;

/**
 * 执行job任务
 *
 * @author siguiyang
 */
public interface IHandler {

    /**
     * 支持的枚举
     *
     * @param jobEnums job枚举
     * @return true 支持， false 不支持
     * @see quick.pager.shop.job.enums.JobEnums
     */
    boolean support(final JobEnums jobEnums);

    /**
     * 前置记录日志
     *
     * @param jobId          任务主键
     * @param jobGroupId     任务组主键
     * @param executorsParam 执行参数
     */
    Long preLog(final Long jobId, final Long jobGroupId, final String executorsParam);

    /**
     * 执行job业务
     *
     * @param jobName  全局定时任务唯一名称
     * @param jobGroup 全局定时任务唯一名称组
     */
    void execute(final String jobName, final String jobGroup);

    /**
     * 后置记录日志
     *
     * @param jobLogId 记录日志主键
     */
    void postLog(final Long jobLogId);
}
