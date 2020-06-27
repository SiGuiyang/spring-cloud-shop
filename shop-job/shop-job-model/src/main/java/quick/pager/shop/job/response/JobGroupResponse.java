package quick.pager.shop.job.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 任务组响应对象
 * @author siguiyang
 */
@Data
public class JobGroupResponse implements Serializable {
    private static final long serialVersionUID = 2164846165607992992L;

    private Long id;
    /**
     * 组服务名称
     */
    private String groupName;
    /**
     * 序号
     */
    private Integer sequence;
}
