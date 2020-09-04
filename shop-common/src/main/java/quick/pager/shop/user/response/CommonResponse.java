package quick.pager.shop.user.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 通用响应对象
 *
 * @author siguiyang
 */
@Data
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = 4795023687882738889L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图标
     */
    private String icon;
}
