package quick.pager.shop.constants;

/**
 * feign client 对外开放服务常量
 *
 * @author siguiyang
 */
public interface ConstantsClient {
    /**
     * 营销服务
     */
    String ACTIVITY_CLIENT = "shop-activity";
    /**
     * 商品服务
     */
    String GOODS_CLIENT = "shop-goods";
    /**
     * 订单服务
     */
    String ORDER_CLIENT = "shop-order";
    /**
     * 风控服务
     */
    String RISK_CLIENT = "shop-risk";
    /**
     * 用户中心服务
     */
    String USER_CLIENT = "shop-user";
    /**
     * 商户中心服务
     */
    String SELLER_CLIENT = "shop-seller";
    /**
     * 平台中心基础服务
     */
    String PLATFORM_CLIENT = "shop-platform";
    /**
     * 定时任务服务
     */
    String JOB_CLIENT = "shop-job";
    /**
     * 购物车服务
     */
    String CART_CLIENT = "shop-cart";
    /**
     * 清结算服务
     */
    String SETTLEMENT_CLIENT = "shop-settlement";
    /**
     * ES服务
     */
    String ELASTICSEARCH_CLIENT = "shop-elasticsearch";
    /**
     * 活动请求前缀
     */
    String ACTIVITY = "/activity";
    /**
     * 商品中心请求前缀
     */
    String GOODS = "/goods";
    /**
     * 数据平台请求前缀
     */
    String MANAGE = "/admin";
    /**
     * 订单中心请求前缀
     */
    String ORDER = "/order";
    /**
     * 商户中心请求前缀
     */
    String SELLER = "/seller";
    /**
     * 用户中心请求前缀
     */
    String USER = "/user";
    /**
     * 风控中心请求前缀
     */
    String RISK = "/risk";
    /**
     * 平台中心请求前缀
     */
    String PLATFORM = "/platform";
    /**
     * 定时任务前缀
     */
    String JOB = "/job";
    /**
     * 购物车
     */
    String CART = "/cart";
    /**
     * 清结算
     */
    String SETTLEMENT = "/settlement";
    /**
     * ES服务
     */
    String ELASTICSEARCH = "/elasticsearch";
}
