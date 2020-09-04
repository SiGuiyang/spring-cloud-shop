package quick.pager.shop.param;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 清结算
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SettlementParam extends Param {
    private static final long serialVersionUID = 3785254179117618026L;

    /**
     * 当前用户主键
     */
    private Long userId;
    /**
     * 配送地址主键
     */
    private Long shipId;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 使用积分
     */
    private Integer integral;
    /**
     * 提交购物车商品明细
     */
    private List<GoodsCartParam> goodsCart;
}
