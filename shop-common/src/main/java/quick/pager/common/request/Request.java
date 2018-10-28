package quick.pager.common.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求基类
 *
 * @author siguiyang
 */
@Data
public class Request implements Serializable {
    private static final long serialVersionUID = -8303934871640269088L;

    /**
     * 主键Id
     */
    private long id;
    /**
     * 用户token
     */
    private String token;

    /**
     * 起始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
}
