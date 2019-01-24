import cn.hutool.core.util.RandomUtil;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import quick.pager.common.constants.Constants;
import quick.pager.common.dto.SmsDTO;
import quick.pager.common.service.RedisService;
import quick.pager.shop.model.common.SmsTemplate;
import quick.pager.shop.model.user.User;
import quick.pager.shop.user.UserApplication;
import quick.pager.shop.user.mapper.SmsTemplateMapper;
import quick.pager.shop.user.mq.MqService;

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

    @Test
    public void testPub() {
        stringRedisTemplate.convertAndSend("hello", "I am come from redis message!");
    }

    @Test
    public void testRedisHash() {
        User user = new User();
        user.setPassword("33333");
        user.setPhone("323234999");
        user.setId(444L);
        String token = RandomUtil.randomUUID().replace("-", "");
        System.out.println(token);
        redisService.setValueOps(String.valueOf(user.getId()), token, 10 * 24 * 60 * 60);

        System.out.println(redisService.getValueOps(String.valueOf(user.getId())));
    }

    @Test
    public void testMq() throws IOException {

        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule("user", Constants.SMS.INITIAL_CIPHER_SMS);
        SmsTemplate smsTemplate = smsTemplates.get(0);
        String content = MessageFormat.format(smsTemplate.getSmsTemplateContent(), "13818471341", "22343");
        SmsDTO smsdto = new SmsDTO();
        smsdto.setPhone("13818471341");
        smsdto.setContent(content);
        mqService.sender(Constants.RabbitQueue.SEND_SMS, smsdto);
        System.in.read();
    }

}
