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
        String ACTIVITY = "activity";
        String GOODS = "goods";
        String MANAGE = "manage";
        String ORDER = "order";
        String SELLER = "seller";
        String SETTLEMENT = "settlement";
        String USER = "user";
    }

    /**
     * RabbitMq 队列的key
     */
    interface RabbitQueue {
        // 短信发送队列
        String SEND_SMS = "sendSMS";
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
