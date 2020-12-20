package quick.pager.shop.activity.enums;

import quick.pager.shop.enums.IEnum;

/**
 * 活动类型
 *
 * @author siguiyang
 */
public enum ActivityTypeEnums implements IEnum<Integer> {

    EXCHANGE(1, "满赠换购活动"),
    ASSEMBLE(2, "拼团活动"),
    SECKILL(3, "秒杀活动");

    private final Integer code;

    private final String desc;

    ActivityTypeEnums(Integer code, String desc) {
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
