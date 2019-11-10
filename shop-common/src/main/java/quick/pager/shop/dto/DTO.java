package quick.pager.shop.dto;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

import java.io.Serializable;

@Data
class DTO implements Serializable {

    private static final long serialVersionUID = -1027750679708024114L;

    /**
     * 服务主键Id
     */
    private Long id;

    /**
     * 操作类型事件
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
}
