package quick.pager.shop.user.enums;

import lombok.Getter;
import quick.pager.shop.enums.IEnum;

/**
 * 站内信状态枚举
 *
 * @author siguiyang
 */
@Getter
public enum NativeMessageStatusEnums implements IEnum<Integer> {

    NON_READ(0, "未读"),
    READ(1, "已读");

    private final Integer code;

    private final String desc;

    NativeMessageStatusEnums(Integer code, String desc) {
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
