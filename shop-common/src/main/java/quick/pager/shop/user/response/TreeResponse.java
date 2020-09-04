package quick.pager.shop.user.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 树形结构响应对象
 *
 * @author siguiyang
 * @version 3.0
 */
@Data
public class TreeResponse implements Serializable {
    private static final long serialVersionUID = -7342067413554624052L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 主键
     */
    private Long value;
    /**
     * 显示值
     */
    private String label;
    /**
     * 显示值
     */
    private String name;

    private List<TreeResponse> children;


}
