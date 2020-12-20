package quick.pager.shop.settlement.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * 清结算
 *
 * @author siguiyang
 */
@Data
public class SettlementCheckRequest implements Serializable {
    private static final long serialVersionUID = 3785254179117618026L;

    /**
     * 当前用户主键
     */
    private Long userId;
    /**
     * 购物车主键集
     */
    private List<Long> goodsCartIds;
    /**
     * 结算金额
     */
    private BigDecimal settlementAmount;
}
