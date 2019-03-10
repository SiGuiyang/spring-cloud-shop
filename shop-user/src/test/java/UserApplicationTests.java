import cn.hutool.core.util.RandomUtil;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.RabbitMqKeys;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.dto.SmsDTO;
import quick.pager.common.handler.AbstractHandler;
import quick.pager.common.mq.MqMessage;
import quick.pager.common.response.Response;
import quick.pager.common.service.RedisService;
import quick.pager.shop.model.common.SmsTemplate;
import quick.pager.shop.model.user.User;
import quick.pager.shop.user.UserApplication;
import quick.pager.shop.user.handler.TestHandler01;
import quick.pager.shop.user.handler.TestHandler02;
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
        mqService.sender(MqMessage.builder().queueName(RabbitMqKeys.SEND_SMS).payLoad(smsdto).build());

        mqService.sender(MqMessage.builder().queueName(RabbitMqKeys.TOPIC_TEST).payLoad("Test.Error").build());
        System.in.read();
    }


    private Properties pro;

    @Before
    public void before() throws IOException {
        InputStream resource = this.getClass().getResourceAsStream("test.properties");
        pro = new Properties();
        pro.load(resource);
    }

    @Test
    public void testProperties() {
        test("shop-user");
        test("shop-seller");
        test("shop-activity");
        test("shop-goods");
        test("shop-manage");
        test("shop-order");
        test("shop-settlement");
    }


    private void test(String serviceId) {
        for (Map.Entry<Object, Object> me : pro.entrySet()) {
            StringBuilder builder = new StringBuilder("insert into `pager_config`.`t_config` (`label`, `profile`, `service_id`, `app_key`, `app_value`) values ('master', 'dev',");
            builder.append("'");
            builder.append(serviceId);
            builder.append("'").append(",");
            builder.append("'");
            builder.append(me.getKey());
            builder.append("'");
            builder.append(",");
            builder.append("'");
            builder.append(me.getValue());
            builder.append("');");
            System.out.println(builder.toString());
        }
    }

    @Test
    public void testHandler() {
        AbstractHandler instance = AbstractHandler.getInstance(TestHandler01.class);
        instance.doHandler("01");

        AbstractHandler instance02 = AbstractHandler.getInstance(TestHandler02.class);
        Response response = instance02.doHandler("02");
        if (response.getCode() == ResponseStatus.Code.SUCCESS) {
            System.out.println(1);
        }
    }

    @Test
    public void testBean(){

    }

}
