package quick.pager.shop.order.response;

import java.io.Serializable;
import lombok.Data;

/**
 * 订单气泡数
 *
 * @author siguiyang
 */
@Data
public class UserOrderQuantityResponse implements Serializable {
    private static final long serialVersionUID = -955161449008299661L;
    /**
     * 待支付
     */
    private Integer payment;
    /**
     * 待收货
     */
    private Integer received;
    /**
     * 待自提
     */
    private Integer raised;
    /**
     * 待评价
     */
    private Integer evaluated;
}
