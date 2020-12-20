package quick.pager.shop.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import quick.pager.shop.user.request.Request;

/**
 * 用户提交订单请求对象
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmitOrderRequest extends Request {
    private static final long serialVersionUID = 7428710264559112811L;
    /**
     * 支付方式
     */
    private Integer payType;
}
