package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;
import quick.pager.shop.mapper.UserInfoMapper;
import quick.pager.shop.mapper.UserMapper;
import quick.pager.shop.model.User;
import quick.pager.shop.model.UserInfo;
import quick.pager.shop.service.UserService;
import quick.pager.shop.utils.Assert;
import quick.pager.shop.utils.DateUtils;

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
        User user = this.userMapper.selectById(userId);

        Assert.isTrue(Objects.nonNull(user), () -> "用户不存在");

        UserInfo userInfo = this.userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId, userId));

        Assert.isTrue(Objects.nonNull(userInfo), () -> "用户信息不存在");

        return Response.toResponse(this.convert(userInfo, user));
    }

    @Override
    public Response<UserProfileResponse> profileInfo(final String phone) {
        log.info("查询用户信息 phone = {}", phone);

        User user = this.userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
        Assert.isTrue(Objects.nonNull(user), () -> "用户不存在");

        UserInfo userInfo = this.userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, user.getId()));

        Assert.isTrue(Objects.nonNull(userInfo), () -> "用户信息不存在");

        return Response.toResponse(this.convert(userInfo, user));
    }

    @Override
    public Response<List<UserProfileResponse>> batchProfile(final UserRequest request) {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        if (CollectionUtils.isNotEmpty(request.getUserIds())) {
            wrapper.in(User::getId, request.getUserIds());
        }

        if (CollectionUtils.isNotEmpty(request.getPhones())) {
            wrapper.in(User::getPhone, request.getPhones());
        }

        List<User> users = this.userMapper.selectList(wrapper);

        Assert.isTrue(CollectionUtils.isNotEmpty(users), () -> "未找到用户");

        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        // 按照用户分组
        Map<Long, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getId));
        List<UserInfo> userInfos = this.userInfoMapper.selectList(new LambdaQueryWrapper<UserInfo>().in(UserInfo::getUserId, userIds));

        return Response.toResponse(userInfos.stream().map(item -> {
            Optional<User> userOptional = map.getOrDefault(item.getUserId(), Lists.newArrayList()).stream().findFirst();
            if (userOptional.isPresent()) {
                return this.convert(item, userOptional.get());
            }
            return this.convert(item, null);

        }).collect(Collectors.toList()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response<UserProfileResponse> login(final String phone) {

        log.info("用户登录手机号码 phone = {}", phone);

        User user = this.userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));

        // 注册
        if (Objects.isNull(user)) {

            User insertUser = new User();

            insertUser.setPhone(phone);
            insertUser.setPassword("Aa123456");
            insertUser.setCreateTime(DateUtils.dateTime());
            insertUser.setUpdateTime(DateUtils.dateTime());
            insertUser.setDeleteStatus(Boolean.FALSE);
            this.userMapper.insert(insertUser);

            UserInfo userInfo = new UserInfo();

            userInfo.setUsername(phone);
            userInfo.setUserId(insertUser.getId());
            userInfo.setCreateTime(DateUtils.dateTime());
            userInfo.setUpdateTime(DateUtils.dateTime());
            userInfo.setDeleteStatus(Boolean.FALSE);

            this.userInfoMapper.insert(userInfo);

            return Response.toResponse(this.convert(userInfo, insertUser));

        }
        // 登录

        UserInfo userInfo = this.userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, user.getId()));

        return Response.toResponse(this.convert(userInfo, user));
    }

    private UserProfileResponse convert(final UserInfo userInfo, final User user) {

        String phone = Objects.nonNull(user) ? user.getPhone() : null;
        return UserProfileResponse.builder()
                .id(userInfo.getUserId())
                .username(userInfo.getUsername())
                .phone(phone)
                .avatar(userInfo.getAvatar())
                .birthday(userInfo.getBirthday())
                .gender(userInfo.getGender())
                .build();
    }
}
