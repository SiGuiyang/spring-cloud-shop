package quick.pager.shop.job.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * job 新增|更新
 *
 * @author siguiyang
 */
@Data
public class JobSaveRequest implements Serializable {

    private static final long serialVersionUID = -6175461011411792825L;
    /**
     * 主键
     */
    private Long id;
    /**
     * job任务组主键
     */
    private Long jobGroupId;

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
     * 任务执行时调用服务名称
     */
    private String serviceName;
    /**
     * 请求访问资源路径
     */
    private String serviceMethod;
    /**
     * 创建时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 描述
     */
    private String updateUser;
}
