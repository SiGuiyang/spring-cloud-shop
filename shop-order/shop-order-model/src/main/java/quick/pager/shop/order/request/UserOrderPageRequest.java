package quick.pager.shop.order.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.user.request.PageRequest;

/**
 * 用户订单列表分页请求参数
 *
 * @author siguiyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserOrderPageRequest extends PageRequest {
    private static final long serialVersionUID = 3403409533500804139L;

    /**
     * 订单Id
     */
    private Long orderId;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 所有订单 1, 待付款 2, 待收货 3, 待自提 4, 待评价 5
     */
    private Integer order;
    /**
     * 订单类型 1，专区订单； 2 普通订单；3 自提订单； 4，秒杀订单，5积分订单
     */
    private Integer orderType;

    private String beginTime;

    private String endTime;

}
