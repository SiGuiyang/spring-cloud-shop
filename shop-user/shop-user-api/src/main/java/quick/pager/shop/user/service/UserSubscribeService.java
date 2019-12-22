package quick.pager.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.service.RedisService;
//import quick.pager.shop.user.param.UserSubscribeDTO;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.mq.KafkaService;
import quick.pager.shop.user.response.LoginOrSubscribeResponse;

/**
 * 用户注册服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserSubscribeService implements IService<LoginOrSubscribeResponse> {

    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private SmsTemplateMapper smsTemplateMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private KafkaService kafkaService;

    @Override
    public Response<LoginOrSubscribeResponse> doService(BaseDTO dto) {

//        UserSubscribeDTO subscribeDTO = (UserSubscribeDTO) dto;
//
//        User user = userMapper.selectByPhone(subscribeDTO.getPhone());
//
//        if (!ObjectUtils.isEmpty(user)) {
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_REGISTERED);
//        }
//
//        String password = RandomUtil.randomNumbers(6);
//        user = new User();
//        user.setPhone(subscribeDTO.getPhone());
//        user.setPassword(SecureUtil.md5(password));
//        user.setCreateTime(DateUtils.dateTime());
//
//        userMapper.insertSelective(user);
//
//
//        String token = RandomUtil.randomUUID().replace("-", "");
//
//        redisService.setValueOps(String.valueOf(user.getId()), token, 10 * 24 * 60 * 60);
//        LoginOrSubscribeResponse loginOrSubscribeResponse = new LoginOrSubscribeResponse();
//        loginOrSubscribeResponse.setPhone(user.getPhone());
//        loginOrSubscribeResponse.setToken(token);
//        loginOrSubscribeResponse.setUserId(user.getId());
//        loginOrSubscribeResponse.setUsername("");
//        loginOrSubscribeResponse.setAvatar("");
//        loginOrSubscribeResponse.setUserId(user.getId());
//
//        // 使用队列发送短信初始密码
//        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule(Constants.SMS_MODULE.USER, Constants.SMS.INITIAL_CIPHER_SMS);
//        SmsTemplate smsTemplate = smsTemplates.get(0);
//        String content = MessageFormat.format(smsTemplate.getSmsTemplateContent(), user.getPhone());
//        SmsDTO smsdto = new SmsDTO();
//        smsdto.setPhone(user.getPhone());
//        smsdto.setContent(content);
//        kafkaService.sender(MqMessage.builder().queueName(RabbitMqKeys.SEND_SMS).payLoad(smsdto).build());
//
//        return new Response<>(loginOrSubscribeResponse);
        return null;
    }
}
