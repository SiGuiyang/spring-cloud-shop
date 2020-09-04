package quick.pager.shop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Job 执行日志
 *
 * @author siguiyang
 */
@TableName("QUARTZ_JOB_LOG")
@Data
public class JobLog implements Serializable {

    private static final long serialVersionUID = -6759760940110322391L;
    @TableId(type = IdType.AUTO)
    private Long id;

    // job info
    private Long jobGroupId;
    private Long jobId;

    // execute info
    private String executorServiceName;
    private String executorServiceMethod;
    private String executorParam;

    // trigger info
    private LocalDateTime triggerTime;
    private int triggerCode;
    private String triggerMsg;

    // handle info
    private LocalDateTime handleTime;
    private int handleCode;
    private String handleMsg;

    // alarm info
    private int alarmStatus;

}
