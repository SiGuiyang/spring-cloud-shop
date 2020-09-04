package quick.pager.shop.cart.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 购物车列表
 *
 * @author siguiyang
 */
@Data
public class GoodsCartResponse implements Serializable {
    private static final long serialVersionUID = 1660182360445628070L;

    /**
     * 商户主键
     */
    private Long id;
    /**
     * 商户名称
     */
    private String name;
    /**
     * 商户Logo
     */
    private String logo;
    /**
     * 购物车商品条目
     */
    private List<GoodsCartDetailResponse> details;
}
