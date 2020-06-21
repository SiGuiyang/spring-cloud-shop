package quick.pager.shop.user.controller.app;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.param.SendParam;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.user.service.SMSCodeService;
import quick.pager.shop.utils.VerifyCodeUtils;

/**
 * 用户验证码方面的接口
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
public class AppUserCodeController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private SMSCodeService smsCodeService;

    /**
     * 发送短信验证码
     */
    @RequestMapping(value = "/app/code/sendSMS", method = RequestMethod.POST)
    public Response sendSMS(@RequestBody SendParam param) {


        return smsCodeService.send(param);
    }


    /**
     * 发送图形验证码
     *
     * @param phone    手机号码
     * @param response response
     */
    @RequestMapping(value = "/app/send/code/graphic", method = RequestMethod.GET)
    public void sendGraphic(@RequestParam String phone, HttpServletResponse response) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //实例生成验证码对象
        VerifyCodeUtils instance = new VerifyCodeUtils();
        //将验证码存入session
        redisService.set(RedisKeys.UserKeys.SHOP_GRAPHICS_CODE + phone, instance.getCode(), 2 * 60);
        //向页面输出验证码图片
        instance.write(response.getOutputStream());

    }
}
