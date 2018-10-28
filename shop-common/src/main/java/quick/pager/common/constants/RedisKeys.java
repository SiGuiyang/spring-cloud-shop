package quick.pager.common.constants;

/**
 * Redis 常量前缀
 *
 * @author siguiyang
 */
public interface RedisKeys {

    // user 模块
    interface UserKeys {

        // 重复登陆提交
        String SHOP_LOGIN = "shop_login_";
        // 登陆验证码
        String SHOP_LOGIN_SMS = "shop_login_sms_";
        // 忘记密码
        String SHOP_FORGET_PASSWORD_SMS = "shop_forget_password_sms_";
        // 注册前缀
        String SHOP_REGISTER = "shop_register_";
        // 注册短信前缀
        String SHOP_REGISTER_SMS = "shop_register_sms_";
        // 配置项缓存前缀
        String SHOP_SYSTEM_CONFIG = "shop_system_config:";
        // 用户短信模板配置
        String SHOP_SMS_TEMPLATE = "shop_sms_template:";
        // 图形验证码
        String SHOP_GRAPHICS_CODE = "SHP_graphics_code_";
    }


}
