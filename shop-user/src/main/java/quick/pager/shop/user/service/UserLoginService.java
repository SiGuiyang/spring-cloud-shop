package quick.pager.shop.user.service;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.shop.user.dto.UserInfoDTO;
import quick.pager.shop.user.dto.UserLoginDTO;
import quick.pager.shop.user.dto.UserSubscribeDTO;
import quick.pager.shop.user.mapper.SmsTemplateMapper;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.redis.RedisService;
import quick.pager.shop.user.response.LoginOrSubscribeResponse;

import java.util.UUID;

/**
 * 用户登陆
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserLoginService implements IService<LoginOrSubscribeResponse> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserSubscribeService userSubscribeService;

    @Override
    public Response<LoginOrSubscribeResponse> doService(DTO dto) {
        UserLoginDTO userLoginDTO = (UserLoginDTO) dto;

        UserInfoDTO user = userMapper.selectInfoByPhone(userLoginDTO.getPhone());

        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在，开始自动登陆并注册 params = {}", JSON.toJSONString(dto));
            UserSubscribeDTO userSubscribeDTO = new UserSubscribeDTO();
            userSubscribeDTO.setPhone(userLoginDTO.getPhone());
            return userSubscribeService.doService(userSubscribeDTO);
        }

        // 账号密码不匹配
        if (!user.getPassword().equals(SecureUtil.md5(userLoginDTO.getPassword()))) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_ACCOUNT_PASSWORD_NOT_CORRECT);
        }

        redisService.delFromHash(user.getId().toString());

        String token = UUID.randomUUID().toString();

        LoginOrSubscribeResponse loginOrSubscribeResponse = new LoginOrSubscribeResponse();
        loginOrSubscribeResponse.setPhone(user.getPhone());
        loginOrSubscribeResponse.setToken(token);
        loginOrSubscribeResponse.setUserId(user.getId());
        loginOrSubscribeResponse.setUsername(user.getUsername());
        loginOrSubscribeResponse.setAvatar(user.getAvatar());
        loginOrSubscribeResponse.setUserId(user.getId());

        redisService.setFromHash(user.getId().toString(), token);


        return new Response<>(loginOrSubscribeResponse);
    }
}
