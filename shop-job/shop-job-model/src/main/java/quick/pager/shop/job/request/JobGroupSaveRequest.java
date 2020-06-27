package quick.pager.shop.job.request;

import java.io.Serializable;
import lombok.Data;

/**
 * Job任务组
 *
 * @author siguiyang
 */
@Data
public class JobGroupSaveRequest implements Serializable {
    private static final long serialVersionUID = -3085944355234922730L;
    /**
     * 任务组名称
     */
    private String name;
}
