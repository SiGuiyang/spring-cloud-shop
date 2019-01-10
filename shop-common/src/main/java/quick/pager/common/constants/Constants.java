package quick.pager.common.constants;

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
    }

    /**
     * RabbitMq 队列的key
     */
    interface RabbitQueue {
        // 短信发送队列
        String SEND_SMS = "sendSMS";
    }

    enum CouponType {

        COUPON(1, "优惠券"),
        DICOUNT(2, "折扣券");

        public int type;
        private String name;

        CouponType(int type, String name) {
            this.type = type;
            this.name = name;
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

}
