package quick.pager.shop.constants;

/**
 * 响应码<br />
 * <p>
 *
 * @author siguiyang
 */
public interface ResponseStatus {

    // 响应码
    interface Code {
        // 错误码
        int FAIL_CODE = 1000;
        // 严重错误码
        int ERROR_CODE = 2000;
        // 异常码
        int EXCEPTION_CODE = 3000;
        // 没有权限返回吗
        int NO_PERMISSION = 5000;
        // 登陆过期
        int LOGIN_EXPIRE = 4000;
        // 成功码
        int SUCCESS = 200;
    }

    String NO_PERMISSION = "您没有权限访问";

    String SUCCESS_MSG = "请求成功";

    String PARAMS_EXCEPTION = "网络出了点小问题";

    String TELNET_EXCEPTION = "网络连接错误，请稍后重试";

    String REPEAT_SUBMIT = "请勿重复提交";

    String USER_PHONE_NOT_EXISTS = "用户不存在";

    String USER_PHONE_EXCEPTION = "用户账号异常，请联系客服！";

    String USER_ACCOUNT_PASSWORD_NOT_CORRECT = "账号或密码不正确";

    String USER_PHONE_REGISTERED = "此号码已注册";

    String USER_GRAPHIC_CODE_EMPTY = "图形验证码不能为空";
    String USER_GRAPHIC_CODE_EXPIRE = "图形验证码已过期";
    String USER_GRAPHIC_CODE_ERROR = "图形验证码不正确";

    String SMS_CODE_NOT_EMPTY = "短信验证码不能为空";


    String SMS_CODE_EXPIRE = "短信验证码已过期";

    String SMS_CODE_ERROR = "短信验证码不正确";

    String LOGIN_EXPIRE = "登陆过期，请重新登陆";

    String GOODS_EXPIRE = "商品已失效";

    String SERVICE_NOT_FOUND = "未找到服务地址";

    String PUBLISH_COUPON_PHONE_IS_BLANK = "发送优惠券手机号码为空";


}
