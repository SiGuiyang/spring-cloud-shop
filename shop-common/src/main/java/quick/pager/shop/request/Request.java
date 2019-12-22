package quick.pager.shop.request;

import java.time.LocalDateTime;
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
     * 主键
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
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 更新操作人
     */
    private String updateUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 启用标志
     */
    private Boolean deleteStatus;
    /**
     * 访问token
     */
    private String access_token;

    private Boolean serverStatus;

}
