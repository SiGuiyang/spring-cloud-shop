package quick.pager.shop.order.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderPageRequest extends PageRequest {
    private static final long serialVersionUID = 3403409533500804139L;

    /**
     * 用户手机号码
     */
    private String phone;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单状态
     *
     * @see quick.pager.shop.order.enums.OrderStatusEnums¬
     */
    private List<String> orderStatus;

    /**
     * 订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单
     *
     * @see quick.pager.shop.order.enums.OrderTypeEnums
     */
    private List<Integer> orderType;
    /**
     * 时间范围
     */
    private List<LocalDateTime> timeRange;

}
