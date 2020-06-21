package quick.pager.shop.activity.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 优惠券类型
 *
 * @author siguiyang
 */
public enum CouponTypeEnums implements IEnum<Integer> {

    COUPON(1, "优惠券"),
    DISCOUNT(2, "折扣券");

    private int type;
    private String name;

    private Integer code;

    private String desc;

    CouponTypeEnums(Integer code, String desc) {
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

    public static CouponTypeEnums parse(int code) {
        for (CouponTypeEnums typeEnums : CouponTypeEnums.values()) {
            if (typeEnums.code == code) {
                return typeEnums;
            }
        }
        return null;
    }
}
