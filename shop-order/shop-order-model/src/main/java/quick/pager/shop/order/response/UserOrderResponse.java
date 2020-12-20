package quick.pager.shop.order.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserOrderResponse implements Serializable {
    private static final long serialVersionUID = -5010619899353666357L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 商户主键
     */
    private Long sellerId;
    /**
     * 配送地址主键
     */
    private Long addrId;
    /**
     * 优惠券主键
     */
    private Long couponId;
    /**
     * 购买人手机号码
     */
    private String phone;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态
     *
     * @see quick.pager.shop.order.enums.OrderStatusEnums
     */
    private String orderStatus;
    /**
     * 订单类型
     *
     * @see quick.pager.shop.order.enums.OrderTypeEnums
     */
    private Integer orderType;
    /**
     * 支付方式
     * 0：支付宝
     * 1：微信
     *
     * @see quick.pager.shop.order.enums.PayTypeEnums
     */
    private Integer payType;
    /**
     * 使用积分
     */
    private Integer integral;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 积分使用金额
     */
    private BigDecimal integralAmount;
    /**
     * 减免金额
     */
    private BigDecimal discountAmount;
    /**
     * 是否支持自提
     */
    private Boolean self;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
