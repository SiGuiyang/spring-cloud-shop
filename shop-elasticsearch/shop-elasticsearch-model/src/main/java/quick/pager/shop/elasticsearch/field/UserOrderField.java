package quick.pager.shop.elasticsearch.field;

/**
 * 用户订单字段
 *
 * @author siguiyang
 */
public interface UserOrderField {

    /**
     * 用户主键
     */
    String USER_ID_KEY = "userId";
    /**
     * 订单主键
     */
    String ORDER_ID_KEY = "orderId";
    /**
     * 订单类型
     */
    String ORDER_TYPE_KEY = "orderType";
    /**
     * 订单编号
     */
    String ORDER_CODE_KEY = "orderCode";
    /**
     * 订单状态
     */
    String ORDER_STATUS_KEY = "orderStatus";
    /**
     * 下单时间
     */
    String ORDER_TIME_KEY = "createTime";
}
