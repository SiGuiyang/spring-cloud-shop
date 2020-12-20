package quick.pager.shop.goods.request.spu;

import java.io.Serializable;
import lombok.Data;

/**
 * spu 其他查询
 *
 * @author siguiyang
 */
@Data
public class GoodsSpuOtherRequest implements Serializable {
    private static final long serialVersionUID = 2028013977123929109L;

    /**
     * spu名称
     */
    private String spuName;
    /**
     * 检索关键字
     */
    private String keyword;
}
