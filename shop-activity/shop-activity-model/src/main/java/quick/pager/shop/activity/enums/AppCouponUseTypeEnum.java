package quick.pager.shop.activity.enums;

import quick.pager.shop.enums.IEnum;

/**
 * APP 优惠券使用类型
 *
 * @author siguiyang
 */
public enum AppCouponUseTypeEnum implements IEnum<String> {


    UNUSED("UNUSED", "未使用"),
    USED("USED", "未使用"),
    EXPIRE("EXPIRE", "未使用");
    private String code;

    private String desc;

    AppCouponUseTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
