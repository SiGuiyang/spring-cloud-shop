package quick.pager.shop.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.common.constants.Constants;
import quick.pager.common.constants.RedisKeys;
import quick.pager.common.constants.ResponseStatus;
import quick.pager.common.request.AppRequest;
import quick.pager.common.response.Response;
import quick.pager.common.service.RedisService;
import quick.pager.shop.feign.dto.UserInfoDTO;
import quick.pager.shop.user.dto.ForgetPasswordDTO;
import quick.pager.shop.user.dto.StationMessageDTO;
import quick.pager.shop.user.dto.UserLoginDTO;
import quick.pager.shop.user.dto.UserSubscribeDTO;
import quick.pager.shop.user.request.ForgetPasswordRequest;
import quick.pager.shop.user.request.LoginRequest;
import quick.pager.shop.user.request.SubscribeRequest;
import quick.pager.shop.user.request.UserInfoRequest;
import quick.pager.shop.user.response.LoginOrSubscribeResponse;
import quick.pager.shop.user.service.StationMessageService;
import quick.pager.shop.user.service.UserForgetPasswordService;
import quick.pager.shop.user.service.UserInfoService;
import quick.pager.shop.user.service.UserLoginService;
import quick.pager.shop.user.service.UserSubscribeService;

/**
 * 用户管理<br />
 * 登陆 注册 退出 用户信息 忘记密码
 *
 * @author siguiyang
 */
@Api(description = "用户模块")
@RestController
@RequestMapping(Constants.Module.USER)
@Slf4j
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserSubscribeService userSubscribeService;
    @Autowired
    private UserForgetPasswordService userForgetPasswordService;
    @Autowired
    private StationMessageService stationMessageService;
    @Autowired
    private RedisService redisService;


    /**
     * 登陆
     */
    @ApiOperation("登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<LoginOrSubscribeResponse> login(LoginRequest request) {

        String key = RedisKeys.UserKeys.SHOP_LOGIN + request.getPhone();

        if (null != redisService.get(key)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.REPEAT_SUBMIT);
        }

        // 图形验证码不能为空
//        if (StringUtils.isEmpty(request.getGraphicCode())) {
//
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_GRAPHIC_CODE_EMPTY);
//        }

        // 密码为空 则使用短信验证码登陆
        if (StringUtils.isEmpty(request.getPassword())) {
            log.info("密码为空，使用短信验证码登陆 phone = {}", request.getPhone());
            // 验证短信验证码
            String smsKey = RedisKeys.UserKeys.SHOP_LOGIN_SMS + request.getPhone();

            String smsCode = redisService.get(smsKey);

            // 短信验证码过期
            if (StringUtils.isEmpty(smsCode)) {
                return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_EXPIRE);
            }

            // 短信验证码是否匹配
            if (!smsCode.equalsIgnoreCase(request.getVerifyCode())) {
                return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_ERROR);
            }
        }

        UserLoginDTO dto = new UserLoginDTO();
        dto.setPassword(request.getPassword());
        dto.setPhone(request.getPhone());

//        redisService.set(key, request.getPhone(), 30);

        return userLoginService.doService(dto);
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/edit")
    public Response edit(UserInfoRequest request) {

        return null;
    }

    /**
     * 注册
     */
    @ApiOperation("注册")
    @RequestMapping(value = "/user/subscribe", method = RequestMethod.POST)
    public Response subscribe(SubscribeRequest request) {
        String key = RedisKeys.UserKeys.SHOP_REGISTER + request.getPhone();

        if (null != redisService.get(key)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.REPEAT_SUBMIT);

        }

        redisService.set(key, request.getPhone(), 30);


        if (StringUtils.isEmpty(request.getVerifyCode())) {

            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_NOT_EMPTY);
        }

        // 验证短信验证码
        String smsKey = RedisKeys.UserKeys.SHOP_REGISTER_SMS + request.getPhone();

        String smsCode = redisService.get(smsKey);

        if (StringUtils.isEmpty(smsCode)) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_EXPIRE);

        }

        if (!smsCode.equalsIgnoreCase(request.getVerifyCode())) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_ERROR);
        }

        UserSubscribeDTO dto = new UserSubscribeDTO();
        dto.setGraphicCode(request.getGraphicCode());
        dto.setVerifyCode(request.getVerifyCode());
        dto.setPhone(request.getPhone());

        return userSubscribeService.doService(dto);
    }

    /**
     * 退出
     */
    @ApiOperation("退出登陆")
    @RequestMapping(value = "/logout/{userId}", method = RequestMethod.POST)
    public Response logout(@PathVariable("userId") Long userId) {
        return null;
    }

    /**
     * 用户信息
     */
    @ApiOperation("用户信息")
    @RequestMapping(value = "/info/{userId}", method = RequestMethod.POST)
    public Response userInfo(@PathVariable("userId") Long userId) {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(userId);
        return userInfoService.doService(dto);
    }

    /**
     * 忘记密码
     */
    @ApiOperation("忘记密码")
    @RequestMapping(value = "/forget/password", method = RequestMethod.POST)
    public Response forgetPassword(ForgetPasswordRequest request) {
        if (StringUtils.isEmpty(request.getPhone())) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        // 验证短信验证码
        String smsKey = RedisKeys.UserKeys.SHOP_FORGET_PASSWORD_SMS + request.getPhone();

        String smsCode = redisService.get(smsKey);

        if (StringUtils.isEmpty(smsCode)) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_EXPIRE);

        }

        if (!smsCode.equalsIgnoreCase(request.getVerifyCode())) {
            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.SMS_CODE_ERROR);
        }

        ForgetPasswordDTO dto = new ForgetPasswordDTO();
        dto.setPhone(request.getPhone());

        return userForgetPasswordService.doService(dto);
    }

    @ApiOperation("站内信列表")
    @RequestMapping(value = "/station/message", method = RequestMethod.POST)
    public Response message(AppRequest request) {
        StationMessageDTO dto = new StationMessageDTO();
        dto.setId(request.getUserId());
        dto.setEvent(request.getEvent());
        dto.setPageSize(request.getPageSize());
        dto.setPage(request.getPage());
        return stationMessageService.doService(dto);
    }

    @ApiOperation("未读站内信个数")
    @PostMapping("/station/count")
    public Response messageCount(@PathVariable("userId") Long userId) {
        StationMessageDTO stationMessageDTO = new StationMessageDTO();
        stationMessageDTO.setUserId(userId);
        stationMessageDTO.setEvent("count");
        return stationMessageService.doService(stationMessageDTO);
    }
}

