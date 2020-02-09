package quick.pager.shop.user.service;

import quick.pager.shop.response.Response;

/**
 * 用户服务
 *
 * @author siguiyang
 */
public interface UserService {

    /**
     * 用户登陆
     *
     * @param phone    手机号码
     * @param password 密码
     * @return 数据响应对象
     */
    Response login(String phone, String password);

    /**
     * 注册开户
     *
     * @param phone 手机号码
     * @return 数据响应对象
     */
    Response subscribe(String phone);
}
