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

    /**
     * 主键Id
     */
    private long id;
    /**
     * 操作事件
     */
    private String event;

}
