package quick.pager.shop.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import quick.pager.shop.job.enums.JobEnums;

/**
 * 数据流转对象
 *
 * @author siguiyang
 */
@Data
@Builder
public class DTO implements Serializable {
    private static final long serialVersionUID = -4094183449196950393L;

    /**
     * job任务主键
     */
    private Long jobId;
    /**
     * job组主键
     */
    private Long jobGroupId;
    /**
     * 全局唯一的job任务名称
     */
    private String jobName;
    /**
     * 任务组
     */
    private String jobGroup;
    /**
     * cron 表达式
     */
    private String cron;
    /**
     * 执行参数
     */
    private String params;

    /**
     * job执行方式
     */
    private JobEnums jobEnums;
}
