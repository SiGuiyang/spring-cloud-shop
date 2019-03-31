package quick.pager.shop.request;

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
    private Long id;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 操作事件
     */
    private String event;

}
