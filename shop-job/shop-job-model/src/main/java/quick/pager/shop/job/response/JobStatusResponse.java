package quick.pager.shop.job.response;

import java.io.Serializable;
import lombok.Data;

/**
 * job任务状态
 *
 * @author siguiyang
 */
@Data
public class JobStatusResponse implements Serializable {
    private static final long serialVersionUID = 7068600043114220277L;

    private int code;

    private String desc;
}
