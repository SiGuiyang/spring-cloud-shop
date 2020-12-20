package quick.pager.shop.settlement.request;

import java.io.Serializable;
import lombok.Data;

/**
 * 结算商品
 *
 * @author siguiyang
 */
@Data
public class SettlementSkuRequest implements Serializable {

    private static final long serialVersionUID = -2731466219255268323L;

    /**
     * sku 商品主键
     */
    private Long skuId;
    /**
     * 购买商品数量
     */
    private Integer quantity;
}
