package quick.pager.shop.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.mq.MqMessage;
import quick.pager.shop.platform.client.SMSTemplateClient;
import quick.pager.shop.platform.response.SMSTemplateResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.model.User;
import quick.pager.shop.user.mq.KafkaService;
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
    private RedisService redisService;
    @Autowired
    private KafkaService kafkaService;
    @Autowired
    private SMSTemplateClient smsTemplateClient;

    @Override
    public Response login(String phone, String password) {
        User queryUser = new User();
        queryUser.setDeleteStatus(Boolean.FALSE);
        queryUser.setPhone(phone);
        User user = userMapper.selectOne(new QueryWrapper<>(queryUser));
        // 用户不存在自动注册
        if (Objects.isNull(user)) {
            return this.subscribe(phone);
        }

        // 账号密码登陆，验证密码是否匹配
        if (StringUtils.isNotBlank(password)
                && !user.getPassword().equals(SecureUtil.md5(password))) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_ACCOUNT_PASSWORD_NOT_CORRECT);
        }

        return new Response();
    }

    @Override
    public Response subscribe(String phone) {
        // 设置初始密码
        String password = RandomUtil.randomStringUpper(6);
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setCreateTime(DateUtils.dateTime());
        user.setDeleteStatus(Boolean.FALSE);

        Response<SMSTemplateResponse> smsTemplateResp = smsTemplateClient.sms("");
        SMSTemplateResponse smsTemplate = smsTemplateResp.getData();
        // TODO 队列发送注册成功后的短信
        MqMessage message = MqMessage.builder()
                .queueName("")
                .payLoad(String.format(smsTemplate.getSmsTemplateContent(), phone, password))
                .build();
        kafkaService.sender(message);

        return new Response();
    }

    /**
     * 创建token
     *
     * @param userId 用户Id
     */
    private String createToken(Long userId) {
        String token = RandomUtil.randomUUID().replace("-", "");

        redisService.setValueOps(String.valueOf(userId), token, 10 * 24 * 60 * 60);
        return token;

    }
}
