package quick.pager.common.constants;

/**
 * Redis 常量前缀
 *
 * @author siguiyang
 */
public interface RedisKeys {

    // 管理后台
    interface ManageKeys {
        // 系统补发优惠券
        String SEND_COUPON_LIST = "send_coupon_list";
    }

    // activity 模块
    interface ActivityKeys {
        // banner 列表
        String SHOP_BANNER_LIST = "shop_banner_list";
    }

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

    // goods 模块
    interface GoodsKeys {
        // 商品分类缓存
        String SHOP_GOODS_CLASS = "pager_goods_class";
    }

    // 通用模块
    interface CommonKeys {
        // 接口访问白名单地址
        String REQUEST_URL_WHITE_LIST = "request_url_white_list:";
    }


}
