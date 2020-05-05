package quick.pager.shop.goods.enums;

/**
 * 商品状态
 *
 * @author siguiyang
 */
public enum GoodsPublishStatusEnum {

    NONE_SHELF(0, "上架申请"),
    REFUSE(1, "拒绝申请"),
    UPPER_SHELF(2, "上架"),
    LOWER_SHELF(3, "下架");

    private int code;

    private String name;

    GoodsPublishStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    public static GoodsPublishStatusEnum parse(int code) {
        for (GoodsPublishStatusEnum statusEnum : GoodsPublishStatusEnum.values()) {
            if (statusEnum.code == code) {
                return statusEnum;
            }
        }
        return null;
    }
}
