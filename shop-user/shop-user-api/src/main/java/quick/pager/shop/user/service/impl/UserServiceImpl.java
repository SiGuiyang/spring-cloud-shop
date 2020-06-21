package quick.pager.shop.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mq.MqMessage;
import quick.pager.shop.platform.client.SMSTemplateClient;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.user.mapper.UserInfoMapper;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.model.User;
import quick.pager.shop.user.model.UserInfo;
import quick.pager.shop.user.mq.KafkaService;
import quick.pager.shop.user.response.UserInfoResponse;
import quick.pager.shop.user.service.UserService;
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
    public Response<UserInfoResponse> profile(final Long userId) {
        log.info("查询用户主键 userId = {}", userId);
        User user = userMapper.selectById(userId);

        if (Objects.isNull(user)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, "用户不存在");
        }

        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getDeleteStatus, Boolean.FALSE)
                .eq(UserInfo::getUserId, userId));

        // 返回用户信息主题信息
        UserInfoResponse userInfoResp = new UserInfoResponse();
        userInfoResp.setAge(Objects.nonNull(userInfo) ? userInfo.getAge() : null);
        return null;
    }
}
