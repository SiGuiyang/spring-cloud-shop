package quick.pager.shop.user.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 基础响应对象
 *
 * @author siguiyang
 */
@Data
public class BasicResponse implements Serializable {

    private static final long serialVersionUID = 5306570320648664002L;
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
}
