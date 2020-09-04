package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;
import quick.pager.shop.param.SellerSubscribeParam;

/**
 * 商户
 */
public interface SellerService {

    /**
     * 登陆
     *
     * @param phone      手机号码
     * @param password   密码
     * @param verifyCode 短信验证码
     */
    Response login(String phone, String password, String verifyCode);


    /**
     * 商户注册完后，申请入驻平台
     *
     * @param param 入驻填写基本信息
     */
    Response subscribe(SellerSubscribeParam param);
}
