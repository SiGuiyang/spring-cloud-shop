package quick.pager.shop.settlement.constants;

/**
 * 清结算
 *
 * @author siguiyang
 */
public interface SettlementRedisKeys {
    /**
     * 积分抵扣
     */
    String INTEGRAL_DEDUCTION = "integral_deduction";
    /**
     * 订单提交幂等性前缀
     */
    String APP_SUBMIT_ORDER = ":app:submit:order:";
}
