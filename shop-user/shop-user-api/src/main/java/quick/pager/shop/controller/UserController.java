package quick.pager.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.service.UserService;
import quick.pager.shop.user.client.UserClient;
import quick.pager.shop.user.request.UserRequest;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.user.response.UserProfileResponse;

@RestController
@RequestMapping(ConstantsClient.USER)
public class UserController implements UserClient {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/profile/{userId}")
    public Response<UserProfileResponse> profile(@PathVariable("userId") Long userId) {
        return userService.profile(userId);
    }

    @Override
    @PostMapping("/profile/{phone}/info")
    public Response<UserProfileResponse> profileInfo(@PathVariable("phone") String phone) {
        return userService.profileInfo(phone);
    }

    @Override
    @PostMapping("/batch/profile")
    public Response<List<UserProfileResponse>> batchProfile(@RequestBody UserRequest request) {
        return userService.batchProfile(request);
    }
}
