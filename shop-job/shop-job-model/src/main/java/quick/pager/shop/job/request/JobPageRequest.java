package quick.pager.shop.job.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * Job 分页请求
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JobPageRequest extends PageRequest {

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
}
