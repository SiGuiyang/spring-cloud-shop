package quick.pager.shop.param;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 基础请求参数
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
public class Param implements Serializable {

    private static final long serialVersionUID = -518713193480019636L;
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
     * 服务状态
     */
    private Boolean serverStatus;
}
