package quick.pager.shop.user.controller;

import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.response.Response;
import quick.pager.shop.user.redis.RedisService;

@RestController
@Api(description = "短信redis测试")
public class TestController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/test/sendSms")
    public Response<String> testSendSms(@RequestParam("phone") String phone, @RequestParam("event") String event) {
        String code = RandomUtil.randomNumbers(6);
        switch (event) {
            case "login":
                redisService.set(RedisKeys.UserKeys.SHOP_LOGIN_SMS + phone, code, 2 * 60);
                break;
            case "register":
                redisService.set(RedisKeys.UserKeys.SHOP_REGISTER_SMS + phone, code, 2 * 60);
                break;
            case "forget":
                redisService.set(RedisKeys.UserKeys.SHOP_FORGET_PASSWORD_SMS + phone, code, 2 * 60);
                break;

        }
        return new Response<>(code);
    }


}
