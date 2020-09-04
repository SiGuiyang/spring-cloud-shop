package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.mapper.UserInfoMapper;
import quick.pager.shop.mapper.UserMapper;
import quick.pager.shop.model.User;
import quick.pager.shop.model.UserInfo;
import quick.pager.shop.service.UserService;
import quick.pager.shop.utils.BeanCopier;

/**
 * 用户登陆
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Response<UserProfileResponse> profile(final Long userId) {
        log.info("查询用户主键 userId = {}", userId);
        User user = userMapper.selectById(userId);

        if (Objects.isNull(user)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "用户不存在");
        }

        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getDeleteStatus, Boolean.FALSE)
                .eq(UserInfo::getUserId, userId));

        return Response.toResponse(this.convert(userInfo));
    }

    private UserProfileResponse convert(final UserInfo userInfo) {
        return BeanCopier.copy(userInfo, new UserProfileResponse());
    }
}
