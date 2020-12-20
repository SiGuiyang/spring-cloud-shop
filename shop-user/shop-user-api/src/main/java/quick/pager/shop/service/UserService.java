package quick.pager.shop.service;

import java.util.List;
import quick.pager.shop.user.request.UserRequest;
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

    /**
     * 根据手机号码查询用户信息
     *
     * @param phone 手机号码
     * @return 用户信息
     */
    Response<UserProfileResponse> profileInfo(final String phone);

    /**
     * 批量获取用户信息
     *
     * @param request 请求参数
     */
    Response<List<UserProfileResponse>> batchProfile(final UserRequest request);

    /**
     * 登录
     *
     * @param phone 手机号码
     * @return 用户信息
     */
    Response<UserProfileResponse> login(final String phone);
}
