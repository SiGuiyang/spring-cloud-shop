package quick.pager.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.dto.BaseDTO;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.IService;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.mq.KafkaService;

/**
 * 忘记密码服务
 *
 * @author siguiyang
 */
@Service
@Slf4j
public class UserForgetPasswordService implements IService {
    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private SmsTemplateMapper smsTemplateMapper;
    @Autowired
    private KafkaService kafkaService;

    @Override
    public Response doService(BaseDTO dto) {

//        ForgetPasswordDTO forgetPasswordDTO = (ForgetPasswordDTO) dto;
//
//        User user = userMapper.selectByPhone(forgetPasswordDTO.getPhone());
//
//        if (ObjectUtils.isEmpty(user)) {
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_NOT_EXISTS);
//        }
//
//        String newPassword = RandomUtil.randomString(6);
//
//        user.setPhone(SecureUtil.md5(newPassword));
//
//        userMapper.updateByPrimaryKeySelective(user);
//
//        // 队列发送短信忘记密码短信
//        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule(Constants.Module.USER, Constants.SMS.FORGET_SMS);
//        SmsTemplate smsTemplate = smsTemplates.get(0);
//        String content = MessageFormat.format(smsTemplate.getSmsTemplateContent(), user.getPhone(), newPassword);
//        SmsDTO smsdto = new SmsDTO();
//        smsdto.setPhone(user.getPhone());
//        smsdto.setContent(content);
//        kafkaService.sender(MqMessage.builder().queueName(RabbitMqKeys.SEND_SMS).payLoad(smsdto).build());
//
        return new Response<>();
    }
}
