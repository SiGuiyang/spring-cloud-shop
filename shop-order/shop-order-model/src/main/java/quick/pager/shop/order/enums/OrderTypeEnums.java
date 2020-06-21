package quick.pager.shop.order.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 订单类型
 *
 * @author siguiyang
 */
public enum OrderTypeEnums implements IEnum<Integer> {
    SPECIAL(1, "专区订单"),
    NORMAL(2, "普通订单"),
    SELF(3, "自提订单"),
    SEC_KILL(4, "秒杀订单"),
    INTEGRAL(5, "积分订单");

    private Integer code;

    private String desc;

    OrderTypeEnums(Integer code, String desc) {
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

    public static OrderTypeEnums parse(int code) {
        for (OrderTypeEnums typeEnums : OrderTypeEnums.values()) {
            if (typeEnums.code == code) {
                return typeEnums;
            }
        }
        return null;
    }
}
