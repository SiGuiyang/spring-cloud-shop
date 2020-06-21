package quick.pager.shop.user.service;

import quick.pager.shop.response.Response;
import quick.pager.shop.user.response.UserInfoResponse;

/**
 * 用户服务
 *
 * @author siguiyang
 */
public interface UserService {

    /**
     * 用户信息详情
     *
     * @param userId 用户主键
     * @return 用户信息
     */
    Response<UserInfoResponse> profile(final Long userId);
}
