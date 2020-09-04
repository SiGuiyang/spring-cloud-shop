package quick.pager.shop.service;

import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;

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
    Response<UserProfileResponse> profile(final Long userId);
}
