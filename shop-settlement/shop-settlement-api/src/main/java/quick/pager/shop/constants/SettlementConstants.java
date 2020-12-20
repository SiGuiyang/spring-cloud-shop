package quick.pager.shop.constants;

/**
 * 常量
 *
 * @author siguiyang
 */
public interface SettlementConstants {

    /**
     * 配送时间缓存
     */
    String REDIS_DELIVERY_TIME = "deliveryTime";
    /**
     * 配送费
     */
    String REDIS_DELIVERY_AMOUNT = "deliveryAmount";
    /**
     * 订单满金额免配送费
     */
    String REDIS_FREE_DELIVERY_ORDER_AMOUNT = "freeDeliveryOrderAmount";
}
