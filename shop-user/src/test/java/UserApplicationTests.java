import cn.hutool.core.util.RandomUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.SmsDTO;
import quick.pager.shop.handler.AbstractHandler;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.model.SmsTemplate;
import quick.pager.shop.model.User;
import quick.pager.shop.UserApplication;
import quick.pager.shop.handler.TestHandler01;
import quick.pager.shop.handler.TestHandler02;
import quick.pager.shop.mapper.SmsTemplateMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@Profile("dev")
public class UserApplicationTests {

    @Autowired
    private RedisService redisService;
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
    public void testRedisLeftPush() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        redisService.setListOps("hello4",list);


        List hello4 = redisService.getListOps("hello4");
        System.out.println(hello4);
    }

    @Test
    public void testMq() throws IOException {

        List<SmsTemplate> smsTemplates = smsTemplateMapper.selectByModule("user", Constants.SMS.INITIAL_CIPHER_SMS);
        SmsTemplate smsTemplate = smsTemplates.get(0);
        String content = MessageFormat.format(smsTemplate.getSmsTemplateContent(), "13818471341", "22343");
        SmsDTO smsdto = new SmsDTO();
        smsdto.setPhone("13818471341");
        smsdto.setContent(content);
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
        System.out.println();
        test("shop-seller");
        System.out.println();
        test("shop-activity");
        System.out.println();
        test("shop-goods");
        System.out.println();
        test("shop-manage");
        System.out.println();
        test("shop-order");
//        test("shop-settlement");
    }


    private void test(String serviceId) {
        for (Map.Entry<Object, Object> me : pro.entrySet()) {
            StringBuilder builder = new StringBuilder("insert into t_config(`label`, `profile`, `service_id`, `app_key`, `app_value`) values ('master', 'dev',");
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
    public void testRedis() {
        redisService.set("abc", "1", 30);
        Serializable abc = redisService.get("abc");

        System.out.println(abc);
        System.out.println(StringUtils.isEmpty(abc));

    }

}
