package quick.pager.shop.order.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 支付方式
 *
 * @author siguiyang
 */
public enum PayTypeEnums implements IEnum<Integer> {

    ALIPAY(1, "支付宝"),
    WECHAT(2, "微信"),
    HUABEI(3, "花呗");

    private int code;

    private String desc;

    PayTypeEnums(int code, String desc) {
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

    public static PayTypeEnums parse(int code) {
        for (PayTypeEnums payTypeEnum : PayTypeEnums.values()) {
            if (payTypeEnum.code == code) {
                return payTypeEnum;
            }
        }
        return null;
    }
}
