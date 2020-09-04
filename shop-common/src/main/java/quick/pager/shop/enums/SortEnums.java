package quick.pager.shop.enums;

/**
 * 通用排序枚举
 *
 * @author siguiyang
 * @version 3.0.0
 */
public enum SortEnums implements IEnum<String> {
    DESC("DESC", "倒序"),
    AES("AES", "升序");
    private String code;

    private String desc;

    SortEnums(String code, String desc) {
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
