package quick.pager.shop.goods.enums;

/**
 * 商品类型
 *
 * @author siguiyang
 */
public enum GoodsTypeEnum {

    NORMAL(1, "普通商品"),
    SPECIAL(2, "特价商品"),
    FIGHT_GROUP(3, "拼团商品"),
    SECOND_KILL(4, "秒杀商品"),
    EXCHANGE(5, "满赠换购商品");

    private int code;
    private String name;

    GoodsTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static GoodsTypeEnum parse(int code) {
        for (GoodsTypeEnum typeEnum : GoodsTypeEnum.values()) {
            if (typeEnum.code == code) {
                return typeEnum;
            }
        }
        return null;
    }
}
