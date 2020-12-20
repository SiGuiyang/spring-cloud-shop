package quick.pager.shop.settlement.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * 清结算生成订单
 *
 * @author siguiyang
 */
@Data
public class SettlementRequest implements Serializable {
    private static final long serialVersionUID = 1955241659178950980L;

    /**
     * 清结算购买商品
     */
    private List<SettlementSkuRequest> skus;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 商户主键
     */
    private Long sellerId;
    /**
     * 配送地址
     */
    private Long addrId;
    /**
     * 优惠券主键
     */
    private Long couponId;
    /**
     * 积分数量
     */
    private Integer integral;
    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 配送时间
     * yyyy-MM-dd HH:mm - yyyy-MM-dd HH:mm
     */
    private String deliveryTime;
    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 特殊需求备注
     */
    private String remark;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 减免金额
     */
    private BigDecimal discountAmount;
    /**
     * 是否支持自提
     */
    private Boolean self;


}
