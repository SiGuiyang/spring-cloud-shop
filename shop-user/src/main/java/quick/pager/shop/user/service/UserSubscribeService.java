package quick.pager.shop.user.service;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import java.text.MessageFormat;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.DTO;
import quick.pager.common.dto.SMSDTO;
import quick.pager.common.response.Response;
import quick.pager.common.service.IService;
import quick.pager.common.service.RedisService;
import quick.pager.shop.model.common.SmsTemplate;
import quick.pager.shop.model.user.User;
import quick.pager.shop.user.dto.UserSubscribeDTO;
import quick.pager.shop.user.mapper.SmsTemplateMapper;
import quick.pager.shop.user.mapper.UserMapper;
import quick.pager.shop.user.mq.MqService;
import quick.pager.shop.user.response.LoginOrSubscribeResponse;

import java.util.Date;

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
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private MqService mqService;

    @Override
    public Response<LoginOrSubscribeResponse> doService(DTO dto) {

        UserSubscribeDTO subscribeDTO = (UserSubscribeDTO) dto;

        User user = userMapper.selectByPhone(subscribeDTO.getPhone());

        if (!ObjectUtils.isEmpty(user)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_REGISTERED);
        }

        String password = RandomUtil.randomNumbers(6);
        user = new User();
        user.setPhone(subscribeDTO.getPhone());
        user.setPassword(SecureUtil.md5(password));
        user.setCreateTime(new Date());

        userMapper.insertSelective(user);


        String token = RandomUtil.randomUUID().replace("-", "");

        redisService.setValueOps(String.valueOf(user.getId()), token, 10 * 24 * 60 * 60);
        LoginOrSubscribeResponse loginOrSubscribeResponse = new LoginOrSubscribeResponse();
        loginOrSubscribeResponse.setPhone(user.getPhone());
        loginOrSubscribeResponse.setToken(token);
        loginOrSubscribeResponse.setUserId(user.getId());
        loginOrSubscribeResponse.setUsername("");
        loginOrSubscribeResponse.setAvatar("");
        loginOrSubscribeResponse.setUserId(user.getId());

        // 使用队列发送短信初始密码
        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule(Constants.Module.USER, Constants.SMS.INITIAL_CIPHER_SMS);
        SmsTemplate smsTemplate = smsTemplates.get(0);
        String content = MessageFormat.format(smsTemplate.getSmsTemplateContent(), user.getPhone());
        SMSDTO smsdto = new SMSDTO();
        smsdto.setPhone(user.getPhone());
        smsdto.setContent(content);
        mqService.sender(Constants.RabbitQueue.SEND_SMS, smsdto);

        return new Response<>(loginOrSubscribeResponse);
    }
}
