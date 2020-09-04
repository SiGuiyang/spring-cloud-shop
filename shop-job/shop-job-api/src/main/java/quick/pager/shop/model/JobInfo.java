package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * 定时任务信息
 *
 * @author siguiyang
 */
@Data
@ToString
@TableName("QUARTZ_JOB_INFO")
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 8984218738753141165L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 任务组主键
     */
    private Long jobGroupId;

    /**
     * 任务状态<br />
     * 0：暂停<br />
     * 1：删除<br />
     * 2：正常<br />
     * @see quick.pager.shop.job.enums.JobStatusEnums
     */
    private Integer jobStatus;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String jobGroup;
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
     * 执行参数
     */
    private String params;
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
