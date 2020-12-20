package quick.pager.shop.order.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 交易方式
 *
 * @author siguiyang
 */
public enum TradeTypeEnums implements IEnum<Integer> {

    PAY(0, "支付下单"),
    REFUSE(1, "退款");

    private Integer code;

    private String desc;

    TradeTypeEnums(Integer code, String desc) {
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

    public static TradeTypeEnums parse(int code) {
        for (TradeTypeEnums typeEnums : TradeTypeEnums.values()) {
            if (typeEnums.code == code) {
                return typeEnums;
            }
        }
        return null;
    }
}
