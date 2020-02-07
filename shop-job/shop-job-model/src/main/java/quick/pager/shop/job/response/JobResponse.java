package quick.pager.shop.job.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Job数据响应
 *
 * @author siguiyang
 */
@Data
public class JobResponse implements Serializable {
    private static final long serialVersionUID = 8180646121377198679L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String jobGroup;
    /**
     * 任务状态<br />
     * 0：暂停<br />
     * 1：删除<br />
     * 2：正常<br />
     */
    private String jobStatus;
    /**
     * cron表达式
     */
    private String cron;
    /**
     * 描述
     */
    private String description;
    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    private String className;
    /**
     * spring bean
     */
    private String springId;
    /**
     * 任务调用的方法名
     */
    private String methodName;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
