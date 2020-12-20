package quick.pager.shop.goods.response.spu;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * spu与分类的树形结构
 *
 * @author siguiyang
 */
@Data
public class GoodsSpuTreeResponse implements Serializable {
    private static final long serialVersionUID = -2529525559374120112L;

    /**
     * 主键
     */
    private Long id;

    private String name;

    /**
     * 树形结构子节点
     */
    private List<GoodsSpuTreeResponse> children;
}
