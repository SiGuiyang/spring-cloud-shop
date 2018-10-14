package quick.pager.common.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求基类
 *
 * @author siguiyang
 */
@Data
public class Request implements Serializable {
    private static final long serialVersionUID = -8303934871640269088L;

    private long id;
    /**
     * 起始时间
     */
    private long beginTime;
    /**
     * 结束时间
     */
    private long endTime;
}
