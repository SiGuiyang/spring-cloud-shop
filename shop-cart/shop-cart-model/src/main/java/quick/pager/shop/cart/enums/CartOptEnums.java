package quick.pager.shop.cart.enums;

import quick.pager.shop.enums.IEnum;

public enum CartOptEnums implements IEnum<String> {

    ADD("ADD", "添加购物车"),
    MODIFY("MODIFY", "修改购物车");

    private String code;

    private String desc;

    CartOptEnums(String code, String desc) {
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
