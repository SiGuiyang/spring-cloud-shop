package quick.pager.shop.job.request;

import java.io.Serializable;
import lombok.Data;

/**
 * Job 分页请求
 *
 * @author siguiyang
 */
@Data
public class JobPageRequest implements Serializable {

    private static final long serialVersionUID = -3168321911092475163L;
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

    /**
     * 页码
     */
    private int page;
    /**
     * 页数
     */
    private int pageSize;
}
