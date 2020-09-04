package quick.pager.shop.order.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 查询订单枚举
 *
 * @author siguiyang
 */
public enum OrderEnums implements IEnum<Integer> {

    ALL(1, "所有订单"),
    PAYMENT(2, "待付款"),
    RECEIVED(3, "待收货"),
    RAISED(4, "待自提"),
    EVALUATED(5, "待评价");

    private Integer code;

    private String desc;

    OrderEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
