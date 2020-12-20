package quick.pager.shop.settlement.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import quick.pager.shop.settlement.dto.DiscountCouponDTO;
import quick.pager.shop.settlement.dto.SettlementAddrDTO;
import quick.pager.shop.settlement.dto.SettlementDeliveryTimeDTO;
import quick.pager.shop.settlement.dto.SettlementPayTypeDTO;
import quick.pager.shop.settlement.dto.SettlementSkuDTO;

/**
 * 支付订单页面数据
 *
 * @author siguiyang
 */
@Data
public class SettlementSkuResponse implements Serializable {
    private static final long serialVersionUID = 2056646863558698263L;

    /**
     * 默认地址
     */
    private SettlementAddrDTO addr;
    /**
     * 配送时间
     */
    private List<SettlementDeliveryTimeDTO> deliveryTime;
    /**
     * 购买的商品
     */
    private List<SettlementSkuDTO> skus;
    /**
     * 支付方式
     */
    private List<SettlementPayTypeDTO> payTypes;
    /**
     * 优惠券
     */
    private List<DiscountCouponDTO> coupons;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 配送费
     */
    private BigDecimal deliveryAmount;
    /**
     * 免配送费金额
     */
    private BigDecimal freeDeliveryAmount;
    /**
     * 使用积分
     */
    private Integer integral;

}
