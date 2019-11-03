package quick.pager.shop.response;

import java.io.Serializable;
import java.util.Date;
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
     * 业务主键
     */
    private Long id;
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
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 启用标志
     */
    private Boolean deleteStatus;
}
