package quick.pager.shop.user.controller;

import cn.hutool.core.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.response.Response;
import quick.pager.common.utils.VerifyCodeUtils;
import quick.pager.shop.user.redis.RedisService;
import quick.pager.shop.user.request.SMSRequest;

import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * 用户验证码方面的接口
 *
 * @author siguiyang
 */
@RestController
@Api(description = "用户验证码方面的接口")
public class UserCodeController {

    @Autowired
    private RedisService redisService;

    /**
     * 发送短信验证码
     */
    @RequestMapping(value = "/user/code/sendSMS", method = RequestMethod.POST)
    @ApiOperation("发送短信验证码")
    public Response sendSMS(SMSRequest request) {
        return null;
    }


    /**
     * 发送图形验证码
     *
     * @param request  request
     * @param response response
     */
    @RequestMapping(value = "/send/code/graphic", method = RequestMethod.GET)
    @ApiOperation("发送图形验证码")
    public void sendGraphic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
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
