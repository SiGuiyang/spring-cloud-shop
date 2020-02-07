package quick.pager.shop.job.request;

import java.io.Serializable;
import lombok.Data;

/**
 * Job请求
 *
 * @author siguiyang
 */
@Data
public class JobRequest implements Serializable {
    private static final long serialVersionUID = -2053427966287214464L;

    /**
     * job名称
     */
    private String jobName;

    /**
     * job组名称
     */
    private String jobGroup;
    /**
     * job 状态
     */
    private Integer jobStatus;

}
