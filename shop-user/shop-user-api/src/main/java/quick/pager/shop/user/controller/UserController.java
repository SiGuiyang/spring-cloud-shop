package quick.pager.shop.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.user.param.UserLoginParam;
import quick.pager.shop.user.request.UserPageRequest;
import quick.pager.shop.user.service.UserService;

/**
 * 用户管理<br />
 * 用户信息 忘记密码
 *
 * @author siguiyang
 */
@RestController
@RequestMapping(Constants.Module.USER)
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;


    /**
     * 用户列表
     *
     * @param request 请求参数
     * @return 数据响应
     */
    @PostMapping("/profile/page")
    public Response page(@RequestBody UserPageRequest request) {

        return null;
    }


    /**
     * 退出
     */
    @GetMapping("/logout/{userId}")
    public Response logout(@PathVariable("userId") Long userId) {
        redisService.del(String.valueOf(userId));
        return new Response();
    }

    /**
     * 用户信息
     */
    @GetMapping("/info/{userId}")
    public Response userInfo(@PathVariable("userId") Long userId) {
        return null;
    }

//
//    /**
//     * 站内信列表
//     */
//    @RequestMapping(value = "/station/message", method = RequestMethod.POST)
//    public Response message(@RequestBody @Valid AppRequest request, BindingResult bindingResult) {
//        BindingResultUtils.getFieldErrorMessage(bindingResult);
//        StationMessageDTO dto = new StationMessageDTO();
//        dto.setId(request.getUserId());
//        dto.setEvent(request.getEvent());
//        dto.setPageSize(request.getPageSize());
//        dto.setPage(request.getPage());
//        return stationMessageService.doService(dto);
//    }
//
//    /**
//     * 未读站内信个数
//     */
//    @PostMapping("/station/count")
//    public Response messageCount(@PathVariable("userId") Long userId) {
//        StationMessageDTO stationMessageDTO = new StationMessageDTO();
//        stationMessageDTO.setUserId(userId);
//        stationMessageDTO.setEvent("count");
//        return stationMessageService.doService(stationMessageDTO);
//    }
}

