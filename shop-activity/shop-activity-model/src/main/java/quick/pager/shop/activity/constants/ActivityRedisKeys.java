package quick.pager.shop.activity.constants;

/**
 * Redis缓存前缀
 *
 * @author siguiyang
 */
public interface ActivityRedisKeys {
    /**
     * APP banner列表前缀
     */
    String APP_BANNER_PREFIX = "APP:BANNER_PREFIX:";
    /**
     * banner分享渠道
     */
    String BANNER_SHARE_CHANNEL = "share_channel";
    /**
     * 补发优惠券失败的手机号
     */
    String COUPON_PUBLISH_FAILURE_PREFIX = "COUPON_PUBLISH_FAILURE:";
}
