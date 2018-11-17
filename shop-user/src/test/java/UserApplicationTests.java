import java.text.MessageFormat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.SMSDTO;
import quick.pager.shop.model.common.SmsTemplate;
import quick.pager.shop.model.user.User;
import quick.pager.shop.user.UserApplication;
import quick.pager.shop.user.mapper.SmsTemplateMapper;
import quick.pager.shop.user.mq.MqService;
import quick.pager.shop.user.redis.RedisService;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserApplicationTests {

    @Autowired
    private RedisService redisService;

    @Autowired
    private MqService mqService;
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPub() {
        stringRedisTemplate.convertAndSend("hello", "I am come from redis message!");
    }

    @Test
    public void testRedisHash() {
        User user = new User();
        user.setPassword("33333");
        user.setPhone("323234999");
        user.setServerStatus((byte) 3);
        user.setId(444L);
        redisService.setFromHash(user.getId() + "", user);

        User fromHash = redisService.getFromHash(user.getId() + "");

        System.out.println(fromHash);
    }

    @Test
    public void testMq() {

        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule(Constants.Module.USER, Constants.SMS.INITIAL_CIPHER_SMS);
        SmsTemplate smsTemplate = smsTemplates.get(0);
        String content = MessageFormat.format(smsTemplate.getSmsTemplateContent(), "13818471341", "22343");
        SMSDTO smsdto = new SMSDTO();
        smsdto.setPhone("13818471341");
        smsdto.setContent(content);
        mqService.sender(Constants.RabbitQueue.SEND_SMS, smsdto);
    }

}
