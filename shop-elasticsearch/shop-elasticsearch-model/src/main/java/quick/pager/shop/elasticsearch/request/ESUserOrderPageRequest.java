package quick.pager.shop.elasticsearch.request;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 用户订单分页查询request
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ESUserOrderPageRequest extends PageRequest {

    private static final long serialVersionUID = 4311576238046914358L;
    /**
     * 订单Id
     */
    private Long orderId;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单状态
     *
     * @see quick.pager.shop.order.enums.OrderStatusEnums
     */
    private String orderStatus;

    /**
     * 所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5
     *
     * @see quick.pager.shop.order.enums.OrderEnums
     */
    private Integer order;
    /**
     * 订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单
     *
     * @see quick.pager.shop.order.enums.OrderTypeEnums
     */
    private Integer orderType;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

}
