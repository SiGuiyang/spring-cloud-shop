package quick.pager.shop.platform.enums;

/**
 * 短信编号枚举
 *
 * @author siguiyang
 */
public enum SMSCodeEnums {

    LOGIN_SMS("1000", "登陆短信验证码"),

    REGISTER_SMS("1001", "注册发送短信验证码"),

    FORGET_SMS("1002", "忘记密码短信验证码"),

    INITIAL_CIPHER_SMS("1003", "发送初始密码短信验证码");

    private String code;

    private String desc;

    SMSCodeEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
