package quick.pager.shop.constants;

/**
 * 常量 + 枚举
 *
 * @author siguiyang
 */
public interface Constants {
    // 冻结
    Byte FROZEN = 1;
    // 正常
    Byte NORMAL = 2;
    // 删除
    Byte DELETE = 3;
    // 成功
    String SUCCESS = "SUCCESS";
    // 失败
    String FAILURE = "FAILURE";

    /**
     * 项目模块
     */
    interface Module {
        String ACTIVITY = "/activity";
        String CART = "/cart";
        String GOODS = "/goods";
        String MANAGE = "/admin";
        String ORDER = "/order";
        String SELLER = "/seller";
        String SETTLEMENT = "/settlement";
        String USER = "/user";
    }

    /**
     * 基础增删改查 操作
     */
    interface Event {
        String LIST = "list";
        String MODIFY = "modify";
        String ADD = "add";
        String DELETE = "delete";
        String INFO = "info";
    }

    /**
     * 优惠券类型
     */
    enum CouponType {

        COUPON(1, "优惠券"),
        DISCOUNT(2, "折扣券");

        private int type;
        private String name;

        CouponType(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 短信模板code
     */
    interface SMS {
        // 登陆短信验证码
        String LOGIN_SMS = "1000";
        // 注册发送短信验证码
        String REGISTER_SMS = "1001";
        // 忘记密码短信验证码
        String FORGET_SMS = "1002";
        // 发送初始密码短信验证码
        String INITIAL_CIPHER_SMS = "1003";

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
        String COUPON_TYPE = "couponType";
        // 订单状态
        String ORDER_STATUS = "orderStatus";
    }

    /**
     * 商品类型
     */
    enum GoodsType {
        NORMAL(1, "普通商品"),
        SPECIAL(2, "特价商品"),
        FIGHT_GROUP(3, "拼团商品"),
        SECOND_KILL(4, "秒杀商品");


        private int type;
        private String name;

        GoodsType(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }

    }

    /**
     * 订单类型
     */
    enum OrderType {
        SPECIAL(1, "专区订单"),
        NORMAL(2, "普通订单"),
        SELF(3, "自提订单"),
        SEC_KILL(4, "秒杀订单");

        private int type;

        private String name;

        OrderType(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 订单状态 <br />
     * 1.订单生成但没有支付，则状态是BS001 <br />
     * 2.订单生成，已支付 <br />
     * 3.商家没有发货，则消费者端与商家端状态是BS002 <br />
     * 4.商家发货，消费者端状态是BS004 <br />
     * 5.商家确认发货完成，消费者端与商家端状态是BS006 <br />
     * 6.三天内用户未评价，订单自动自动完成，状态是BS008 <br />
     * 7.三天内用户评价，消费者端与商家端订单完成，状态是BS008 <br />
     * 8.如果订单是自提类型，消费者端与商家端的状态是BS007 <br />
     * 9.如果订单是自提类型，商家确认发货，走步骤5
     * 10.如果订单状态是BS002与BS004状态时，消费者端可以申请退款和取消订单 <br />
     * 11.当消费者端申请退款后，消费者端状态BS010，商家端状态BS012 <br />
     * 12.当退款完成后，消费者端状态BS011，商家端状态BS013，也就是说，只有消费者退款的订单，商家端才会有已关闭的状态<br />
     * 13.当消费者取消订单后，消费者端与商家端状态BS009 <br />
     * 14.如果商家不方便发货，商家与消费者沟通，无法配送，商家取消订单 BS009 <br />
     */
    enum OrderStatus {

        BS001("BS001", "待付款"),
        BS002("BS002", "待发货"),
        BS003("BS003", "已发货"),
        BS004("BS004", "待收获"),
        BS005("BS005", "已签收"),
        BS006("BS006", "待评价"),
        BS007("BS007", "待自提"),
        BS008("BS008", "已完成"),
        BS009("BS009", "已取消"),
        BS010("BS010", "退款中"),
        BS011("BS011", "已退款"),
        BS012("BS012", "退货中"),
        BS013("BS013", "已关闭");

        private String status;

        private String name;

        OrderStatus(String status, String name) {
            this.status = status;
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }
    }

}
