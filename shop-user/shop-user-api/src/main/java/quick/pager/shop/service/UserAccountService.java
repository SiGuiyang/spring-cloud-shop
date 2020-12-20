package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserAccountResponse;

/**
 * 用户账户
 *
 * @author siguiyang
 */
public interface UserAccountService {

    /**
     * 根据用户主键查询用户账户信息
     *
     * @param userId 用户主键
     * @return 户账户信息
     */
    Response<UserAccountResponse> account(final Long userId);
}
