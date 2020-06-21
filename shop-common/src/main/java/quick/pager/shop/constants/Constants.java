package quick.pager.shop.constants;

/**
 * 常量 + 枚举
 *
 * @author siguiyang
 */
public interface Constants {
    /**
     * 冻结
     */
    Byte FROZEN = 1;
    /**
     * 正常
     */
    Byte NORMAL = 2;
    /**
     * 删除
     */
    Byte DELETE = 3;
    /**
     * 成功
     */
    String SUCCESS = "SUCCESS";
    /**
     * 失败
     */
    String FAILURE = "FAILURE";

    /**
     * 项目模块
     */
    interface Module {
        String ACTIVITY = "/fallback";
        String CART = "/cart";
        String GOODS = "/goods";
        String MANAGE = "/admin";
        String ORDER = "/order";
        String SELLER = "/seller";
        String USER = "/user";
        String RISK = "/risk";
        String PLATFORM = "/platform";
        String OSS = "/oss";
    }

    /**
     * 基础增删改查 操作
     */
    interface Event {
        String LIST = "list";
        String MODIFY = "modify";
        String ADD = "add";
        String DELETE = "delete";
        String DELETE_ALL = "deleteAll";
        String INFO = "info";
    }

    /**
     * 短信模块
     */
    interface SMS_MODULE {
        String SELLER = "seller";
        String USER = "user";
    }

    /**
     * 常用字符串数字常量
     */
    interface Common {
        String ZERO = "0";
        String ONE = "1";
        String TWO = "2";
        String THREE = "3";
        String FOUR = "4";
        String FIVE = "5";
        String SIX = "6";
        String SEVEN = "7";
        String EIGHT = "8";
        String NINE = "9";
    }

    /**
     * 通用枚举类型
     */
    interface Type {
        // 商品类型
        String GOODS_TYPE = "goodsType";
        // 订单类型
        String ORDER_TYPE = "orderType";
        // 优惠券类型
        String OFFER_TYPE = "offerType";
        // 订单状态
        String ORDER_STATUS = "orderStatus";
        // 模块类型
        String MODULE_TYPE = "moduleType";
        // banner 分享渠道
        String SHARE_CHANNEL = "shareChannel";
        // banner 类型
        String BANNER_TYPE = "bannerType";
    }

    /**
     * 逗号
     */
    String COMMA = ",";
    /**
     * 竖线
     */
    String VERTICAL_LINE = "|";

}
